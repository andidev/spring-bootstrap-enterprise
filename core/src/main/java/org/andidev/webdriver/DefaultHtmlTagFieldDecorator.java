package org.andidev.webdriver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class DefaultHtmlTagFieldDecorator extends DefaultFieldDecorator {

    private HtmlTagFactory htmlTagFactory;
    private HtmlTagListFactory htmlTagListFactory;

    public DefaultHtmlTagFieldDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
        this.htmlTagFactory = new DefaultHtmlTagFactory();
        this.htmlTagListFactory = new DefaultHtmlTagListFactory(htmlTagFactory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (isDecoratableHtmlTag(field)) {
            return decorateHtmlTag(loader, field);
        }
        if (isDecoratableHtmlTagList(field)) {
            return decorateHtmlTagList(loader, field);
        }
        return null;
    }

    private boolean isDecoratableHtmlTag(Field field) {
        if (!HtmlTag.class.isAssignableFrom(field.getType())) {
            return false;
        }

        return true;
    }

    private boolean isDecoratableHtmlTagList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        // Type erasure in Java isn't complete. Attempt to discover the generic
        // type of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return false;
        }

        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

//        if (!HtmlTag.class.equals(listType)) {
//            return false;
//        }

        if (!HtmlTag.class.isAssignableFrom((Class) listType)) {
            return false;
        }

        if (field.getAnnotation(FindBy.class) == null
                && field.getAnnotation(FindBys.class) == null) {
            return false;
        }

        return true;
    }

    private Object decorateHtmlTag(final ClassLoader loader, final Field field) {
        ElementLocator locator = createLocator(field);
        Class type = (Class<? extends HtmlTag>) field.getType();
        final WebElement webElement = proxyForLocator(loader, locator);
        final By by = ReflectionUtils.getBy(locator);
        final HtmlTag htmlTag = htmlTagFactory.create(type, webElement, by);
        if (hasAnnotatedSearchContext()) {
//            annotatedSearchContext = ;
//            PageFactory.initElements(new DefaultHtmlTagFieldDecorator(annotatedSearchContext), htmlTag);                    
            PageFactory.initElements(new DefaultHtmlTagFieldDecorator(webElement), htmlTag);        
        } else {
            PageFactory.initElements(new DefaultHtmlTagFieldDecorator(webElement), htmlTag);        
        }
        return htmlTag;
    }

    private Object decorateHtmlTagList(final ClassLoader loader, final Field field) {
        ElementLocator locator = createLocator(field);
        Class listType = ReflectionUtils.getListType(field);
        List<WebElement> webElements = proxyForListLocator(loader, locator);
        final By by = ReflectionUtils.getBy(locator);
        final List<? extends HtmlTag> htmlTagList = htmlTagListFactory.create(listType, webElements, by);
        return htmlTagList;
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

    private boolean hasAnnotatedSearchContext() {
        return false;
    }
}
