package testsuite1;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement loginlink = driver.findElement(By.className("ico-login"));
        loginlink.click();
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = welcomeMessage.getText();
        String expectedMessage = "Welcome, Please Sign In!";
        Assert.assertEquals("Verifying WelcomeMessage", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement email_id = driver.findElement(By.id("Email"));
        email_id.sendKeys("hemipatel14000gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("hemipatel");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();
    }

    @Test
    public void verifyTheErrorMessage() throws InstantiationError {
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        WebElement email_id = driver.findElement(By.id("Email"));
        email_id.sendKeys("hemeepatel@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("hemeepatel");

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();


        WebElement welcomeMessage=driver.findElement(By.xpath("//h1[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));

        System.out.println("welcomeMessage: " +welcomeMessage);

        String actualMessage = welcomeMessage.getText();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals("Verifying WelcomeMessage",expectedMessage,actualMessage);
    }
    @After
    public void Close(){
        CloseBrowser();
    }
}

