package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class loginTest extends Utility {
    String baseURL = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextToElement(By.id("user-name"), "problem_user");

        //Enter password
        sendTextToElement(By.xpath("//input[@name='password']"), "secret_sauce");

        //click on login button
        clickOnElement(By.id("login-button"));

        //verify the text "Products"
        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Error","Products",actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
         //Enter username
        sendTextToElement(By.id("user-name"), "problem_user");

        //Enter the password
        sendTextToElement(By.xpath("//input[@name='password']"), "secret_sauce");

        //Click on the login button
        clickOnElement(By.id("login-button"));

        //Verify the six products are displayed on page
        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumber = number.size();
        int expectedNumber = 6;
        Assert.assertEquals("6 product displayed", expectedNumber, actualNumber);
        System.out.println("Number of Products:" + actualNumber);
        }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
