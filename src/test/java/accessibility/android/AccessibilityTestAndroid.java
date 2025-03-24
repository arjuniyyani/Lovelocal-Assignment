package accessibility.android;

import base.MobileBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import utils.AccessibilityUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AccessibilityTestAndroid extends MobileBase {
    @Test
public void testAccessibility() {
    List<WebElement> elements = driver.findElements(By.xpath("//*"));

        System.out.println("Checking for elements missing content-desc...");
    int missingCount = 0;

        for (WebElement el : elements) {
        String contentDesc = el.getAttribute("content-desc");
        if (contentDesc == null || contentDesc.isEmpty()) {
            System.out.println("Missing content-desc for element: class=" + el.getTagName() +
                    ", text=" + el.getText() +
                    ", resource-id=" + el.getAttribute("resource-id"));
            missingCount++;
        }
    }

        System.out.println("Total elements missing content-desc: " + missingCount);
        driver.quit();
}
@Test
public void testTouchAccessibility(){
        int densityDpi = 440; // Example density, replace with adb value if known

        List<WebElement> elements = driver.findElements(By.xpath("//*"));
        System.out.println("Checking for minimum touch target size compliance (48dp × 48dp)...");

        for (WebElement el : elements) {
            Dimension size = el.getSize();
            double widthPx = size.width;
            double heightPx = size.height;

            double widthDp = (widthPx * 160) / densityDpi;
            double heightDp = (heightPx * 160) / densityDpi;

            if (widthDp < 48 || heightDp < 48) {
                System.out.println("Element below minimum touch target size: " +
                        "\nClass: " + el.getTagName() +
                        "\nText: " + el.getText() +
                        "\nResource-id: " + el.getAttribute("resource-id") +
                        "\nWidth(dp): " + widthDp + ", Height(dp): " + heightDp);
            }
    }
        driver.quit();


    }
    @Test
    public void testColorContrast() throws IOException {
        WebElement textElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Sauce Labs')]"));

        // Get location and size
        Point location = textElement.getLocation();
        int x = location.getX();
        int y = location.getY();
        int width = textElement.getSize().width;
        int height = textElement.getSize().height;

        // Take screenshot
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(scrFile);

        // Sample pixel in center of text element
        int textPixelX = x + width / 2;
        int textPixelY = y + height / 2;
        Color textColor = new Color(fullImg.getRGB(textPixelX, textPixelY));

        // Sample background pixel near text element
        int bgPixelX = x + width + 10; // sampling nearby to the right
        int bgPixelY = y + height / 2;
        Color bgColor = new Color(fullImg.getRGB(bgPixelX, bgPixelY));

        double contrastRatio = AccessibilityUtils.calculateContrastRatio(textColor, bgColor);
        System.out.println("Text color: " + textColor + ", Background color: " + bgColor);
        System.out.println("Contrast ratio: " + contrastRatio);

        if (contrastRatio < 4.5) {
            System.out.println("⚠ Accessibility Issue: Contrast below 4.5:1");
        } else {
            System.out.println("✅ Contrast is acceptable.");
        }

        driver.quit();
    }

    }

