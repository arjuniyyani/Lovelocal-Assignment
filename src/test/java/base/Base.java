package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class Base {
    protected WebDriver driver;
    public String baseURL = "https://www.saucedemo.com/";

    @Parameters("browser")
    @BeforeClass
    // Method to initialize the browser
    public void setUp(@Optional("firefox")String browser) {
        System.setProperty("webdriver.gecko.driver", "/Users/arjunraju/IdeaProjects/Selenium/src/main/resources/geckodriver 2");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
    }
    // Method to launch a URL
    public void launchUrl(String url) {
        driver.get(url);
    }
@AfterClass
    // Method to quit the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }



}
