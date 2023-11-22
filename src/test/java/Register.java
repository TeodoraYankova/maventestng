
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Register {

    @Test
    private static void testRegister() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4200/posts/all");

        // click on "Log In" button
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

//        get URL title
//        String pageTitle = driver.getTitle();
//        System.out.println(pageTitle);

        // click on "Register" button
        WebElement register = driver.findElement(new By.ByXPath("//*[contains(text(),\"Register\")]"));
        register.click();

//        // validate Sign up form is visible
//        WebElement signUpFrom = driver.findElement(By.cssSelector(".h4"));
//        Assert.assertTrue(signUpFrom.isDisplayed(), "The Sign up form is not visible!");

        // enter  Username
        WebElement username = driver.findElement(By.xpath("//*[@formcontrolname='username']"));
        username.sendKeys("Teo");

        // enter email
        WebElement email = driver.findElement(By.xpath("//*[@formcontrolname='email']"));
        email.sendKeys("teo@abv.bg");

        // enter password
        WebElement password = driver.findElement(By.xpath("//*[@formcontrolname='password']"));
        password.sendKeys("test123");

//        // enter confirm password
//        WebElement confirmPassword = driver.findElement(By.id("//*[@id='defaultRegisterPhonePassword'] "));
//        confirmPassword.sendKeys("test123");

        // click on "Sign in" button
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        signInButton.click();

        //check if the toast for "Registration failed!" is visible
        WebElement regFailed = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(regFailed.isDisplayed(), "Massage is not visible!");

        driver.close();

    }

}
