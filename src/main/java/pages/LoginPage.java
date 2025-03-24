package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By logoutButton = By.id("logout_sidebar_link");
    By menuButton = By.id("react-burger-menu-btn");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    // Actions
    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        By usernameField = By.id("user-name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        System.out.println("username entered");
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By passwordField = By.id("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutButton).click();
    }
    public boolean isLoginPageDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
