package mobilepages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AppiumDriver driver;

    private By usernameField = By.id("com.saucelabs.mydemoapp.android:id/nameET"); // Replace with actual ID
    private By passwordField = By.id("com.saucelabs.mydemoapp.android:id/passwordET"); // Replace with actual ID
    private By loginButton = By.id("com.saucelabs.mydemoapp.android:id/loginBtn"); // Replace with actual ID

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
