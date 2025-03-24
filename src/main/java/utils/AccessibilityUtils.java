package utils;

import java.awt.*;

public class AccessibilityUtils {
    public static double calculateContrastRatio(Color c1, Color c2) {
        double l1 = getLuminance(c1);
        double l2 = getLuminance(c2);
        return (Math.max(l1, l2) + 0.05) / (Math.min(l1, l2) + 0.05);
    }
    private static double getLuminance(Color color) {
        double r = color.getRed() / 255.0;
        double g = color.getGreen() / 255.0;
        double b = color.getBlue() / 255.0;

        r = (r <= 0.03928) ? r / 12.92 : Math.pow((r + 0.055) / 1.055, 2.4);
        g = (g <= 0.03928) ? g / 12.92 : Math.pow((g + 0.055) / 1.055, 2.4);
        b = (b <= 0.03928) ? b / 12.92 : Math.pow((b + 0.055) / 1.055, 2.4);

        return 0.2126 * r + 0.7152 * g + 0.0722 * b;
    }
}
