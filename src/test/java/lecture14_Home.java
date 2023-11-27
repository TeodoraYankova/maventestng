import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class lecture14_Home {

    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        //   WebDriverManager.firefoxdriver().setup();
        //   WebDriverManager.edgedriver().setup();
        //   WebDriverManager.operadriver().setup();
    }

    @BeforeMethod
    protected final void setUpMethod() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    protected final void tearDown() {
//        if (this.driver != null) {
//            this.driver.close();
//        }
//    }

//    @DataProvider(name = "getUsers")
//    public Object[][] getUsers() {
//        return new Object[][]{
//                {"tedi.qnkova@abv.bg", "test123", "Tedi"}
//        };
//    }

    @Test()
    public void testLoginHomePage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //open website
        driver.get("http://training.skillo-bg.com:4200/posts/all");
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));

        //validate page title is matching the expected page
        String pageTitle = driver.getTitle();
        Assert.assertEquals("ISkillo", pageTitle);

        // click on "Log In" button
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        loginLink.click();

        //wait until login page is open
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));

        //enter username
        WebElement emailField = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        emailField.sendKeys("Tedi");

        //enter password
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("test123");

        //click on Remember me checkbox
        WebElement checkbox = driver.findElement(By.xpath("//*[@formcontrolname='rememberMe']"));
        checkbox.click();

        //check that the checkbox is selected
        Assert.assertTrue(checkbox.isSelected(), "The checkbox is not selected!");

        //click on signIn button
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

        //wait for the login page to be loaded
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));

        //check that the search bar is visible
        WebElement searchField = driver.findElement(By.xpath("//*[@id='search-bar']"));
        wait.until(ExpectedConditions.elementToBeClickable(searchField));

        //click on user link
        WebElement userLink = driver.findElement(By.linkText("//*[@href='/users/5068']"));
        userLink.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/5068"));

        //open post
        WebElement openAPost = driver.findElement(By.xpath("//*[@src='https://i.imgur.com/sB995GN.jpg']']"));
        openAPost.click();

        //check that comment field is visible
        WebElement commentField = driver.findElement(By.xpath("//*[@formcontrolname='content']"));
        wait.until(ExpectedConditions.elementToBeClickable(commentField));
        // commentField.click();

        //click on Follow button
        WebElement followButton = driver.findElement(By.xpath("//*[@class=\"btn btn-primary ng-star-inserted\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(followButton));
        followButton.click();

        //click on Unfollow button


        //like a post
        WebElement likeAPost = driver.findElement(By.xpath("//*[@class='like far fa-heart fa-2x']"));
    //    WebElement likeAPost = driver.findElement(By.id("like far fa-heart fa-2x"));
        likeAPost.click();

        //dislike a post
      //  WebElement dislikePost = driver.findElement(By.xpath("//*[@class='ml-4 far fa-thumbs-down fa-2x liked']"));
        WebElement dislikePost = driver.findElement(By.className("ml-4 far fa-thumbs-down fa-2x"));
        dislikePost.click();

    }

}
