package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutForm(String fName, String lName, String pCode) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(pCode);
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }
}
