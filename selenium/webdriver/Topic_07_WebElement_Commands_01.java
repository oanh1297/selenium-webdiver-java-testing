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
    public void TC_02_() {
    }

    @Test
    public void TC_03_() {
    }

    @Test
    public void TC_04_() {
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
