package org.andidev.webdriver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class ReflectionUtils {

    public static By getBy(WebElement webElement) {
        return getBy(getLocator(webElement));
    }
    
    public static By getBy(ElementLocator locator) {
        try {
            Field byField = locator.getClass().getDeclaredField("by");
            byField.setAccessible(true);
            By by = (By) byField.get(locator);
            byField.setAccessible(false);
            return by;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static ElementLocator getLocator(WebElement webElement) {
        try {
            Field locatorField = webElement.getClass().getDeclaredField("locator");
            locatorField.setAccessible(true);
            ElementLocator locator = (ElementLocator) locatorField.get(locatorField);
            locatorField.setAccessible(false);
            return locator;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static Class<? extends HtmlTag> getListType(Field field) {
        Type genericType = field.getGenericType();
        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];
        return (Class<? extends HtmlTag>) listType;
    }
}
