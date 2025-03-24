package android;

import base.MobileBase;
import mobilepages.android.HomePage;
import mobilepages.android.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.DataUtils;
import io.qameta.allure.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class FunctionalityTest extends MobileBase {

    @Epic("Android Automation")
    @Feature("Login")
    @Description("Verify login functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify login with valid and invalid credentials")
    @Test(dataProvider = "MobileloginData",dataProviderClass = DataUtils.class)
    public void loginAndVerifyInventory(String username, String password)  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.accessmenu();
        homePage.clickMenuItem("Login Menu Item");
        loginPage.login(username,password);
        if(username.equals("locked_out_user")){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/nameErrorTV")));
            System.out.println("Login failed for locked user: " + username);
        } else if(username.equals("")|password.equals("")){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/nameErrorTV")));
            System.out.println("Username and password cannot be null");

        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("android.view.ViewGroup")));
            HomePage inventoryPage = new HomePage(driver);
            System.out.println("Products available: " + inventoryPage.getProductCount());
        }

    }
    @Epic("Android Automation")
    @Feature("Checkout")
    @Description("Verify checkout functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify checkout with valid credentials")
    @Test
    public void testAddToCartAndCheckout(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.accessmenu();
        homePage.clickMenuItem("Login Menu Item");
        loginPage.login("standard_user", "secret_sauce");
        homePage.addToCart("Sauce Labs Backpack");
        homePage.checkout();
        homePage.fillCheckoutForm("John", "Doe", "12345", "standard_user","Kerala","India","680703");
        homePage.finishOrder();

    }
    @Epic("Android Automation")
    @Feature("Product")
    @Description("Verify product details")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify product images")
    @Test
    public void checkProductImages(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mobilepages.android.ProductPage productPage = new mobilepages.android.ProductPage(driver);
        homePage.accessmenu();
        homePage.clickMenuItem("Login Menu Item");
        loginPage.login("standard_user","secret_sauce");
        productPage.openProductDetails("Sauce Labs Backpack");
        productPage.areImagesScrollable();
    }
    @Epic("Android Automation")
    @Feature("Product")
    @Description("Verify product details")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify product description")
    @Test
    public void checkProductDetails(){
        HomePage homePage = new HomePage(driver);
        homePage.accessmenu();
        mobilepages.android.ProductPage productPage = new mobilepages.android.ProductPage(driver);
        homePage.clickMenuItem("Login Menu Item");
        productPage.openProductDetails("Sauce Labs Backpack");
        productPage.isProductDescriptionMatching();
    }
    @Test
    @Epic("Android Automation")
    @Feature("Cart")
    @Description("Verify add to cart functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Verify add to cart")
    public void verifyAddToCart(){
        HomePage homePage = new HomePage(driver);
        homePage.accessmenu();
        homePage.clickMenuItem("Login Menu Item");
        homePage.addToCart("Sauce Labs Backpack");
        homePage.isRemoveButtonVisible("Sauce Labs Backpack");
    }

}
