package mobilepages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CartPage {
    private AppiumDriver driver;
    private By checkoutButton = By.id("com.example:id/checkout_button"); // Replace with actual ID

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}

