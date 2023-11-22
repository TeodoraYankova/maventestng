package lecture11iSkilloAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iSkilloAutomatedTests {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //openiSkillo();
        testCommands();
    }

    private static void openiSkillo() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/posts/all");
        driver.manage().window().maximize();
        //  driver.close();

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
     //   username.click();
        username.sendKeys("T");

        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys("test");
        username.clear();

       // driver.close();

    }

    public static void testCommands() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4200/posts/all");

        String titleOfPage = driver.getTitle();
        System.out.println("The page title is: "  + titleOfPage);

    }

}
