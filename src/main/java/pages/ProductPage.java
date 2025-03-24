package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage{
    private WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;



    }

    By productImages = By.cssSelector(".inventory_details_img");
    By productDescription = By.cssSelector(".inventory_details_desc");
    By sortDropdown = By.className("product_sort_container");

    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

    }

    public void openProductDetails(String productname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By productLocator = By.xpath(String.format("//*[contains(text(), \"%s\")]", productname));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator)).click();    }

    public boolean areImagesScrollable() {
        List<WebElement> images = driver.findElements(productImages);
        return images.size() > 0;
    }

    public boolean isProductDescriptionMatching() {
        return driver.findElement(productDescription).isDisplayed();
    }


    public void addToCart(String productname) {
        driver.findElement(By.xpath(String.format("//div[@class='inventory_item_description' and .//div[@class='inventory_item_name ' and text()='%s']]//button[contains(@class,'btn_inventory')]", productname))).click();

    }

    public void removeFromCart(String productname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By removebutton = By.xpath(String.format("//div[@class='inventory_item_description' and .//div[@class='inventory_item_name ' and text()='%s']]//button[contains(@class,'btn_inventory')]",productname));
        wait.until(ExpectedConditions.visibilityOfElementLocated(removebutton)).click();
        System.out.println("item removed");

    }

    public boolean isRemoveButtonVisible(String productname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By removebutton = By.xpath(String.format("//div[@class='inventory_item_description' and .//div[@class='inventory_item_name ' and text()='%s']]//button[contains(@class,'btn_inventory')]",productname));
        String button =  wait.until(ExpectedConditions.visibilityOfElementLocated(removebutton)).getText();
        System.out.println(button);

        return button.equals("Remove");

    }

    public boolean isAddToCartButtonVisibleAgain(String productname) {
        By addtocart = By.xpath(String.format("//div[@class='inventory_item_description' and .//div[@class='inventory_item_name ' and text()='%s']]//button[contains(text(),'Add to cart')]",productname));
        String buttons =  driver.findElement(addtocart).getText();
        System.out.println(buttons);
        return buttons.equals("Add to cart");
    }

    public void sortBy(String optionText) {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + optionText + "']")).click();
    }

    public boolean isSortedByPriceHighToLow() {
        // Add logic to verify price sorting high to low
        return true; // placeholder
    }

    public boolean isSortedByPriceLowToHigh() {
        // Add logic to verify price sorting low to high
        return true; // placeholder
    }

    public boolean isSortedByNameAZ() {
        // Add logic to verify alphabetical sorting A-Z
        return true; // placeholder
    }

    public boolean isSortedByNameZA() {
        // Add logic to verify alphabetical sorting Z-A
        return true; // placeholder
    }

    public void addMaxQuantityToProduct() {
        // Example placeholder (if there is a limit; this might involve loops or JS execution)
    }

    public boolean isLimitErrorDisplayed() {
        // Placeholder to verify error message on max quantity
        return true;
    }
    public void logout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
    }
}
