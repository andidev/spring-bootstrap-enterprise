package org.andidev.selenium;

import org.junit.Assert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.fest.assertions.api.Assertions;
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
        Assertions.assertThat(webElement.getText()).isNotEmpty();
    }

    public static void assertTextContains(String expected, WebElement webElement) {
        delay();
        Assertions.assertThat(webElement.getText()).contains(expected);
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
    
    
    
    /*
     * FEST like bot
     */
    public static class AssertThatCommands {
        WebElement webElement;
        public AssertThatCommands(WebElement webElement) {
            this.webElement = webElement;
        }
        
        public void equals(String expected) {
            Assertions.assertThat(webElement.getText()).equals(expected);
        }
        
        public void contains(String expected) {
            Assertions.assertThat(webElement.getText()).contains(expected);
        }

    }
    
    public static AssertThatCommands assertThat(WebElement webElement) {
        delay();
        return new AssertThatCommands(webElement);
        
    }    

    

    public static class TypeCommands {
        String str;
        public TypeCommands(String str) {
            this.str = str;
        }
        
        public TypeCommands in(WebElement webElement) {
            webElement.sendKeys(str);
            return this;
        }
        
        public TypeCommands and(WebElement webElement) {
            webElement.sendKeys(str);
            return this;
        }
    }
    
    public static TypeCommands type(String str) {
        delay();
        if (str == null) {
            return null;
        }
        return new TypeCommands(str);
    }


    
    public static class SelectCommands {
        TextEnum en;
        public SelectCommands(TextEnum en) {
            this.en = en;
        }
        
        public void fromDropDownList(WebElement webElement) {
            new Select(webElement).selectByVisibleText(en.getText());
        }
    }    
    
    public static SelectCommands select(TextEnum en) {
        delay();
        return new SelectCommands(en);
    } 
    
}
