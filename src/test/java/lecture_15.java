import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class lecture_15 {

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
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }

//    @AfterMethod
//    protected final void tearDown() {
//        if (this.driver != null) {
//            this.driver.close();
//        }
//    }

    @Test
    public void testAandB() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement linkAB = driver.findElement(By.xpath("//*[@href='/abtest']"));
        linkAB.click();

        WebElement buttonElementalSelenium = driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']"));
        wait.until(ExpectedConditions.visibilityOf(buttonElementalSelenium));

    }

    @Test
    public void addRemoveElement() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement addRemoveElement = driver.findElement(By.xpath("//*[@href='/add_remove_elements/']"));
        addRemoveElement.click();

        WebElement addElementButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        wait.until(ExpectedConditions.elementToBeClickable(addElementButton));

        //click four times on "Add Element" button
        for (int i = 0; i < 4; i++) {
            addElementButton.click();
        }

        //get all delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.id("//*[@id='elements']"));

        //array list to store all delete buttons
        ArrayList<WebElement> addedElements = new ArrayList<>();

        //check if there are at least 3 delete buttons
        if (deleteButtons.size() >= 3) {
            //add the last 3 delete buttons to the arrayList
            for (int i = deleteButtons.size() - 3; i < deleteButtons.size(); i++) {
                addedElements.add(deleteButtons.get(i));
            }

            //click on the 3rd delete button to remove it
            addedElements.get(2).click();

            //verify that the 3rd element is removed
            List<WebElement> remainingElements = driver.findElements(By.xpath("//*[@id='elements']"));
            Assert.assertEquals(remainingElements.size(), 3, "The 3rd button is not removed");
        }
    }

    @Test
    public void testBasicAuth() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement basicAuthButton = driver.findElement(By.xpath("//a[@href='/basic_auth' and contains(text(), 'Basic Auth')]"));
        basicAuthButton.click();
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/basic_auth"));
//        wait.until(ExpectedConditions.);
//
//        Alert alert =driver.switchTo().alert();

//        alert.sendKeys("test");
//        alert.accept();

//        // Handle the basic authentication alert
//        Alert alert = driver.switchTo().alert();
//        // Enter the username and password
//        alert.sendKeys("username:password");
//        // Accept the alert
//        alert.accept();
//
//        // Verify the successful login
//        String successMessage = driver.findElement(By.cssSelector(".example p")).getText();
//        if (successMessage.contains("Congratulations")) {
//            System.out.println("Login successful!");
//        } else {
//            System.out.println("Login failed!");
//        }




    }

    @Test
    public void testBrokenImages() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement brokenImagesButton = driver.findElement(By.linkText("Broken Images"));
        brokenImagesButton.click();

        //





    }

    @Test
    public void testChallengingDOM() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement challengingDOMButton = driver.findElement(By.linkText("Challenging DOM"));
        challengingDOMButton.click();



    }

    @Test
    public void testCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));

        WebElement checkboxesButton = driver.findElement(By.linkText("Checkboxes"));
        checkboxesButton.click();



    }

    @Test
    public void testContentManu() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDesignAuthentication() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDisappearingElements() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDragAndDrop() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDropdown() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDynamicContent() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }

    @Test
    public void testDynamicControls() {
        driver.get("http://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/"));


    }


}


