package mobilepages.reactnative;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver driver;
    private By usernameField = By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"); // Replace with actual ID
    private By passwordField = By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"); // Replace with actual ID
    private By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]"); // Replace with actual ID
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    };

}
