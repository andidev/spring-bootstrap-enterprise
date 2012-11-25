package org.andidev.selenium;

import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverBot {

    public static double delayTime = 0;

    public static void click(WebElement webElement) {
        delay();
        webElement.click();
    }

    public static void type(String str, WebElement webElement) {
        if (str == null) {
            return;
        }
        delay();

        webElement.sendKeys(str);
    }

    public static void pressKeys(WebElement webElement, CharSequence... keysToSend) {
        delay();
        webElement.sendKeys(keysToSend);
    }

    public static void pressEnter(WebElement webElement) {
        delay();
        webElement.sendKeys(Keys.ENTER);
    }

    public static void clear(WebElement webElement) {
        webElement.clear();
        delay();
    }

    public static void clearAndType(String str, WebElement webElement) {
        if (str == null) {
            return;
        }
        clear(webElement);
        type(str, webElement);
    }

    public static boolean isChecked(WebElement webElement) {
        delay();
        return webElement.isSelected();
    }

    public static void check(WebElement webElement) {
        delay();
        if (!isChecked(webElement)) {
            webElement.click();
        }
    }

    public static void uncheck(WebElement webElement) {
        delay();
        if (isChecked(webElement)) {
            webElement.click();
        }
    }

    public static String read(WebElement webElement) {
        delay();
        return webElement.getText();
    }

    public static void select(TextEnum textEnum, WebElement webElement) {
        delay();
        new Select(webElement).selectByVisibleText(textEnum.getText());
    }

    public static void open(WebPage page) {
        delay();
        page.get();
    }

    public static void assertIsLoaded(WebPage page) {
        delay();
        page.isLoaded();
    }

    public static void assertIsDisplayed(WebElement webElement) {
        delay();
        webElement.isDisplayed();
    }

    public static void assertText(String expected, WebElement webElement) {
        delay();
        Assert.assertEquals(expected, webElement.getText());
    }

    public static void assertTextContains(String expected, WebElement webElement) {
        delay();
        Assert.assertTrue(webElement.getText().contains(expected));
    }

    public static void delay(double seconds) {
        if (seconds > 0) {
            try {
                Thread.sleep((long) (seconds * 1000));
            } catch (InterruptedException ex) {
                // Swallow exception
                ex.printStackTrace();
            }

        }
    }

    private static void delay() {
        delay(delayTime);
    }
}
