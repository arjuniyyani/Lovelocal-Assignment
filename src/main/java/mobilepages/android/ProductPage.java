package mobilepages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private AppiumDriver driver;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void addItemToCart(String productName) {
        By productButton = By.xpath("//android.widget.TextView[@text='" + productName + "']/following-sibling::android.widget.Button");
        driver.findElement(productButton).click();
    }
    public void openProductDetails(String productname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By product = By.xpath(String.format("//android.widget.TextView[@content-desc='Product Title' and @text=\"%s\"]/ancestor::android.view.ViewGroup/android.widget.ImageView", productname));
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
    }
    public void areImagesScrollable(){
        By image = By.className("android.widget.ImageView");
        driver.findElement(image).click();
    }
    public void isProductDescriptionMatching(){
        By description = By.id("com.example:id/product_description");
        driver.findElement(description).click();
    }
}