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
import java.util.List;

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

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{
                {"tedi.qnkova@abv.bg", "test123", "Tedi"}
        };
    }

    @Test(dataProvider = "getUsers")
    public void testLoginHomePage(String userName, String password, String email) {

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
        WebElement username = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        username.sendKeys("Tedi");

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

        //click on Profile button
        WebElement profileButton = driver.findElement(By.id("nav-link-profile"));
        profileButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/5066"));

        //click on private button
        WebElement privateButton = driver.findElement(By.xpath("//*[@class='btn-private btn btn-primary']"));
        privateButton.click();
        //  wait.until(ExpectedConditions.elementToBeSelected(privateButton));

//        //wait until "Private" tab is selected
//        WebElement privateTab = driver.findElement(By.xpath("//*[@class='btn-private btn btn-primary active']"));
//        wait.until(ExpectedConditions.elementToBeSelected(privateTab));

//        //click on the post
//        WebElement imgButton = driver.findElement(By.xpath("//*[@src='https://i.imgur.com/QXMf6HA.jpg']"));
//        imgButton.click();

//        //check that comment field is visible
//        WebElement commentField = driver.findElement(By.xpath("//*[@formcontrolname='content']"));
//        wait.until(ExpectedConditions.elementToBeClickable(commentField));
//        // commentField.click();
//
//        //click on like button
//        WebElement likeButton = driver.findElement(By.xpath("//*[@class='like far fa-heart fa-2x']"));
//        likeButton.click();
//
//        //wait until toast "Post licked" is visible
//        WebElement toastLicked = driver.findElement(By.xpath("//*[@class='toast-bottom-right toast-container']"));
//        wait.until(ExpectedConditions.visibilityOf(toastLicked));
//
//        WebElement likeCounter = driver.findElement(By.xpath("//div[2]/div[1]/strong"));
//        wait.until(ExpectedConditions.visibilityOf(likeCounter));
//
//        //click on dislike button
//        WebElement dislikesButton1 = driver.findElement(By.xpath("//*[@class='ml-4 far fa-thumbs-down fa-2x']"));
//        dislikesButton1.click();

//        //click on unlike button
//        WebElement unlikeButton = driver.findElement(By.xpath("//*[@class='like far fa-heart fa-2x liked']"));
//        unlikeButton.click();
//
//        //click on dislike button
//        WebElement dislikesButton2 = driver.findElement(By.xpath("//*[@class='ml-4 far fa-thumbs-down fa-2x liked']"));
//        dislikesButton2.click();


//        //click on a post
//        WebElement postButton = driver.findElement(By.xpath("//*[@class='post-img']"));
//        postButton.click();
//
//        //check that comment field is visible
//        WebElement commentField = driver.findElement(By.xpath("//*[@formcontrolname='content']"));
//        wait.until(ExpectedConditions.elementToBeClickable(commentField));
//        // commentField.click();
//


//        //wait until toast "Post licked" is visible
//        WebElement toastLicked = driver.findElement(By.xpath("//*[@class='toast-bottom-right toast-container']"));
//        wait.until(ExpectedConditions.visibilityOf(toastLicked));
//
//        //click on dislikes button
//        WebElement dislikesButton = driver.findElement(By.xpath("//*[@class='ml-4 far fa-thumbs-down fa-2x']"));
//        dislikesButton.click();
//        dislikesButton.click();

//        //wait until toast "Post disliked" is visible
//        WebElement toastDisliked = driver.findElement(By.xpath("//*[@class='ml-4 far fa-thumbs-down fa-2x'"));
//        wait.until(ExpectedConditions.visibilityOf(toastDisliked));

    }

    @Test(dataProvider = "getUsers")
    public void followUnfollowPage(String userName, String password, String email) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://training.skillo-bg.com:4200/users/login");

        //enter username
        WebElement username = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        username.sendKeys("Tedi");

        //enter password
        WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordField.sendKeys("test123");

        //click on signIn button
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

        //wait for the login page to be loaded
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));


    }

}
