import base.Base;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataUtils;

import java.time.Duration;

public class SauceDemoTest extends Base {
    @Epic("Web Automation")
    @Feature("Login")
    @Severity(SeverityLevel.CRITICAL)

    @Test(description ="verify login and inventory",dataProvider = "loginData",dataProviderClass = DataUtils.class)
    public void loginAndVerifyInventory(String url, String username, String password) {
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        if(username.equals("locked_out_user")){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
            System.out.println("Login failed for locked user: " + username);
        } else if(username.equals("")|password.equals("")){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));
            System.out.println("Username and password cannot be null");

        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));
            InventoryPage inventoryPage = new InventoryPage(driver);
            System.out.println("Products available: " + inventoryPage.getProductCount());
            inventoryPage.printProductDetails();
        }
        }

    @Test
    public void testAddToCartAndCheckout() {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.finishOrder();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-complete"), "Checkout completion page not reached!");
        loginPage.logout();
    }
    @Epic("Web Automation")
    @Feature("Logout")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Browser back after logout")
    public void browserBackAfterLogout() {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.logout();
        driver.navigate().back();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Should redirect to login page after browser back");
    }

//    @Test(description = "Check max buying limit for a product")
//    public void checkMaxBuyingLimit() {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.open();
//        productPage.addMaxQuantityToProduct();
//        Assert.assertTrue(productPage.isLimitErrorDisplayed(), "Max buying limit not enforced");
//        productPage.logout();
//
//
//    }
    @Epic("Web Automation")
    @Feature("Product")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check product images scroll and visibility")
    public void checkProductImages() {
        ProductPage productPage = new ProductPage(driver);
        productPage.open();
        productPage.openProductDetails("Sauce Labs Backpack");
        Assert.assertTrue(productPage.areImagesScrollable(), "Product images are not scrollable or broken");
        productPage.logout();

    }
    @Epic("Web Automation")
    @Feature("Product")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check product details match selected product")
    public void checkProductDetails() {
        ProductPage productPage = new ProductPage(driver);
        productPage.open();
        productPage.openProductDetails("Sauce Labs Backpack");
        Assert.assertTrue(productPage.isProductDescriptionMatching(), "Product description mismatch");
        productPage.logout();

    }
    @Epic("Web Automation")
    @Feature("Cart")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify add to cart button functionality")
    public void verifyAddToCart() {
        ProductPage productPage = new ProductPage(driver);
        productPage.open();
        productPage.addToCart("Sauce Labs Backpack");
        Assert.assertTrue(productPage.isRemoveButtonVisible("Sauce Labs Backpack"), "Add to cart button did not change to remove");
        productPage.logout();

    }

//    @Test(description = "Verify remove from cart button functionality")
//    public void verifyRemoveFromCart() throws InterruptedException {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.open();
//        productPage.addToCart("Sauce Labs Backpack");
//        productPage.removeFromCart("Sauce Labs Backpack");
//        Assert.assertTrue(productPage.isAddToCartButtonVisibleAgain("Sauce Labs Backpack"), "Remove button did not change back to add to cart");
//        productPage.logout();
//
//    }
//    @Test(description = "Product sort by price High to Low")
//    public void productSortHighToLow() {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.sortBy("Price (high to low)");
//        Assert.assertTrue(productPage.isSortedByPriceHighToLow(), "Products not sorted from high to low");
//    }
//    @Test(description = "Product sort by price Low to High")
//    public void productSortLowToHigh() {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.sortBy("Price (low to high)");
//        Assert.assertTrue(productPage.isSortedByPriceLowToHigh(), "Products not sorted from low to high");
//    }
//
//    @Test(description = "Product sort by Name A-Z")
//    public void productSortByNameAZ() {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.sortBy("Name (A to Z)");
//        Assert.assertTrue(productPage.isSortedByNameAZ(), "Products not sorted A to Z");
//    }
//
//    @Test(description = "Product sort by Name Z-A")
//    public void productSortByNameZA() {
//        ProductPage productPage = new ProductPage(driver);
//        productPage.sortBy("Name (Z to A)");
//        Assert.assertTrue(productPage.isSortedByNameZA(), "Products not sorted Z to A");
//    }


}
