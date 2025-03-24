package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    private By firstAddToCartButton = By.cssSelector(".inventory_item:first-child button");
    private By cartIcon = By.className("shopping_cart_link");

    // Locators
    private By productList = By.className("inventory_item");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public int getProductCount() {
        List<WebElement> products = driver.findElements(productList);
        return products.size();
    }

    public void printProductDetails() {
        List<WebElement> products = driver.findElements(productList);
        for (WebElement product : products) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            String price = product.findElement(By.className("inventory_item_price")).getText();
            System.out.println(name + " - " + price);
        }
    }
    public void addFirstItemToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(firstAddToCartButton)).click();

    }
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
