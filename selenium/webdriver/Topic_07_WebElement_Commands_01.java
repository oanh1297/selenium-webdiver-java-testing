package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Displayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#email")).isDisplayed()){
            driver.findElement(By.cssSelector("input#email")).sendKeys("Automation Testing");
            System.out.println("Email Textbox is displayed");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='under_18']")).click();
            System.out.println("Under 18 Radio is displayed");
        } else {
            System.out.println("Under 18 Radio is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Email Textarea is displayed");
        } else {
            System.out.println("Email Textarea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.xpath("//h5[text()='Name: User5']"));
            System.out.println("Name User5 is displayed");
        } else {
            System.out.println("Name User5 is not displayed");
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("input#email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
    }

    @Test
    public void TC_02_Enable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#email")).isEnabled()){
            System.out.println("Email Textbox is displayed");
        } else {
            System.out.println("Email Textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()){
            System.out.println("Password Textbox is displayed");
        } else {
            System.out.println("Password Textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()){
            System.out.println("Checkbox is displayed");
        } else {
            System.out.println("Checkbox is not displayed");
        }

    }

    @Test
    public void TC_03_Selected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
        driver.findElement(By.cssSelector("input#java")).click();
        sleepInseconds(2);

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.cssSelector("input#email")).clear();
        driver.findElement(By.cssSelector("input#email")).sendKeys("AutomationFC@gmail.com");

        //Case 1: Only input number
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        sleepInseconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        //Case 2:Lower case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("auto");
        sleepInseconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        //Case 3: Upper case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("AUTO");
        sleepInseconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());
        //Case 4: Special case
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@!#$");
        sleepInseconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        //Case 5: Max Length
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345678");
        sleepInseconds(2);
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        //Case 6: Valid
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Test123!@#");
        sleepInseconds(2);
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
        // Case 7: Empty
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("button#create-account-enabled")).click();



    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInseconds(long timeInsecond){
        try {
            Thread.sleep((timeInsecond * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
