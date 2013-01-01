package org.andidev.webdriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HtmlTagListFactory {
    <T extends HtmlTag> List<T> create(Class<T> htmlTagClass, List<WebElement> webElements, By by);
}
