package mobilepages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckoutPage {
    private AppiumDriver driver;
    private By placeOrderButton = By.id("com.example:id/place_order_button"); // Replace with actual ID

    public CheckoutPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {
        driver.findElement(placeOrderButton).click();
    }
}