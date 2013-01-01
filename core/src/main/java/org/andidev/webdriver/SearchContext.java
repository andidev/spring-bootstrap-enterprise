package org.andidev.webdriver;

import org.openqa.selenium.support.How;

public @interface SearchContext {

    How how() default How.ID;

    String using() default "";

    String id() default "";

    String name() default "";

    String className() default "";

    String css() default "";

    String tagName() default "";

    String linkText() default "";

    String partialLinkText() default "";

    String xpath() default "";
}