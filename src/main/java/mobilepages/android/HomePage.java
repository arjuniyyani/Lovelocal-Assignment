package mobilepages.android;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {
    private AppiumDriver driver;
    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }
    private By menubutton = By.xpath("//android.widget.ImageView[@content-desc=\"View menu\"]");
    private By carticon = By.xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]");
    private By productlist = By.className("android.view.ViewGroup");
    public void accessmenu(){
        driver.findElement(menubutton).click();
    }
    public void clickMenuItem(String menuItemName) {
        WebElement menuItem = driver.findElement(AppiumBy.accessibilityId(menuItemName));
        menuItem.click();
    }
    public int getProductCount(){
        List<WebElement> products = driver.findElements(productlist);
        return products.size();
    }
    public void gotocart(){
        driver.findElement(carticon).click();
    }

    public void addToCart(String productname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By product = By.xpath(String.format("//android.widget.TextView[@content-desc='Product Title' and @text=\"%s\"]/ancestor::android.view.ViewGroup/android.widget.ImageView", productname));
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
        By addtocartbtn = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addtocartbtn)).click();
    }

    public void checkout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By cartbtn = By.xpath("//android.widget.RelativeLayout[@content-desc=\"Displays number of items in your cart\"]/android.widget.ImageView");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartbtn)).click();
        By checkoutbtn = By.id("com.saucelabs.mydemoapp.android:id/cartBt");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutbtn)).click();
    }

    public void fillCheckoutForm(String fullname, String addressline1, String addressline2, String city, String state, String postalcode, String country) {
        By ifullname = By.id("com.saucelabs.mydemoapp.android:id/fullNameET");
        By iaddressline1 = By.id("com.saucelabs.mydemoapp.android:id/address1ET");
        By iaddressline2 = By.id("com.saucelabs.mydemoapp.android:id/address2ET");
        By icity = By.id("com.saucelabs.mydemoapp.android:id/cityET");
        By istate = By.id("com.saucelabs.mydemoapp.android:id/stateET");
        By ipostalcode = By.id("com.saucelabs.mydemoapp.android:id/zipET");
        By icountry = By.id("com.saucelabs.mydemoapp.android:id/countryET");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ifullname)).sendKeys(fullname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(iaddressline1)).sendKeys(addressline1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(iaddressline2)).sendKeys(addressline2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(icity)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(istate)).sendKeys(state);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ipostalcode)).sendKeys(postalcode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(icountry)).sendKeys(country);


    }

    public void finishOrder() {
        By placeOrderButton = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
        driver.findElement(placeOrderButton).click();
        By Fullname = By.id("com.saucelabs.mydemoapp.android:id/nameET");
        By cardnumber = By.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
        By expirydate = By.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
        By cvv = By.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
        By finishorder = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
        By placeorder = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
        By OrderPlaced = By.id("com.saucelabs.mydemoapp.android:id/completeTV");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Fullname)).sendKeys("John Doe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardnumber)).sendKeys("1234567890123456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirydate)).sendKeys("12/23");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvv)).sendKeys("123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishorder)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeorder)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(OrderPlaced)).isDisplayed();
    }

    public void isRemoveButtonVisible(String productname) {
        By removeButton = By.xpath("//android.widget.TextView[@text='" + productname + "']/following-sibling::android.widget.Button");
        driver.findElement(removeButton).isDisplayed();
    }
}
