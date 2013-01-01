package org.andidev.webdriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class HtmlTag implements WebElement {

    public By by;
    public WebElement wrappedWebElement;

    public HtmlTag(WebElement webElement, By by) {
        this.by = by;
        this.wrappedWebElement = webElement;
    }

    @Override
    public void click() {
        wrappedWebElement.click();
    }

    @Override
    public void submit() {
        wrappedWebElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        wrappedWebElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        wrappedWebElement.clear();
    }

    @Override
    public String getTagName() {
        return wrappedWebElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return wrappedWebElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return wrappedWebElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return wrappedWebElement.isEnabled();
    }

    @Override
    public String getText() {
        return wrappedWebElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wrappedWebElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return wrappedWebElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return wrappedWebElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return wrappedWebElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return wrappedWebElement.getSize();
    }

    @Override
    public String getCssValue(String propertyName) {
        return wrappedWebElement.getCssValue(propertyName);
    }
}
