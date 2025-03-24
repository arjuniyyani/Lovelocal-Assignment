package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class ReactBase {
    public static AppiumDriver driver;
    @BeforeMethod
    public void setUpMobile() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Medium Phone API 36");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/main/resources/apk/mda-2.2.0-25.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }
    @AfterMethod
    public void tearDownMobile() {
        if (driver != null) {
            driver.quit();
        }
    }
}
