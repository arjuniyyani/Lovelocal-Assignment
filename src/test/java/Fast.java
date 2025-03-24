import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Fast {
    public static void main(String[] args) {
        // Set up ChromeDriver path if not set in system PATH
        System.setProperty("webdriver.gecko.driver", "/Users/arjunraju/IdeaProjects/Selenium/src/main/resources/geckodriver 2");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://fast.com");

            // Wait up to 60 seconds for the speed result to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement t = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='oc-icon speed-progress-indicator-icon oc-icon-refresh']")));
            if(t.isDisplayed()){
            WebElement speedValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speed-value")));
                String speed = speedValue.getText();
                System.out.println("Your Internet speed is: " + speed + " Mbps");}

            // Get the speed and print it


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
