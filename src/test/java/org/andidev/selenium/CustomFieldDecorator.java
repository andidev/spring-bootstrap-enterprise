package org.andidev.selenium;

import java.lang.reflect.Field;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override 
    public Object decorate(ClassLoader loader, Field field) {
        if (WebContainer.class.isAssignableFrom(field.getType())
                || WebContainerList.class.isAssignableFrom(field.getType())
                || "webElement".equals(field.getName())) {
            return null;
        }
        return super.decorate(loader, field);
    }
}
