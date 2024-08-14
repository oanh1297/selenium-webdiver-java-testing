package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_08_Textbox_Textarea {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Email_And_Password() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(3);

        driver.findElement(By.cssSelector("button#send2")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");


    }

    @Test
    public void TC_02_Invalid_Email() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("123@123.567");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("Test123");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");


    }

    @Test
    public void TC_03_Invalid_Password() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("Automation_test@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC_04_Login_Incorrect_Email_Or_Password() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(3);

        driver.findElement(By.cssSelector("input#email")).sendKeys("Automation_test123@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("Test123");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");

        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#pass")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("Automation_test1234@gmail.com");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("Test123@");
        driver.findElement(By.cssSelector("button#send2")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");


    }

    @Test
    public void TC_05_Login_Success() {
        driver.get("http://live.techpanda.org");
        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(3);

        // Dang ky 1 tak khoan
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInseconds(2);

        String firstName = "Automation", lastName ="Test", emailAddress = getEmailAddress(), password = "123456789";
        String fullName = firstName + " " + lastName;
        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        sleepInseconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
        Assert.assertEquals((driver.findElement(By.cssSelector("div.welcome-msg strong")).getText()),"Hello, " + fullName + "!");

        String contactInfo =  driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInseconds(2);
        driver.findElement(By.cssSelector("a[title ='Log Out']")).click();

        //Login

        driver.findElement(By.xpath("//div[@class ='footer']//a[@title ='My Account']")).click();
        sleepInseconds(2);
        driver.findElement(By.cssSelector("input#email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#pass")).sendKeys(password);
        driver.findElement(By.cssSelector("button#send2")).click();

        contactInfo =  driver.findElement(By.xpath("//h3[text()= 'Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        //Verify Account

        driver.findElement(By.xpath("//a[text()= 'Account Information']")).click();
        sleepInseconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#firstname")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#lastname")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#email")).getAttribute("value"), emailAddress);


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInseconds(long timeInsecond) {
        try {
            Thread.sleep((timeInsecond * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "automation" + rand.nextInt(99999) + "@gmail.com";

    }

}
