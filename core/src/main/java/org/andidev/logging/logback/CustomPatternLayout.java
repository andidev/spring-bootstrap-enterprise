package org.andidev.logging.logback;

import ch.qos.logback.classic.PatternLayout;

/**
 *
 * @author anders
 * 
 * see http://www.codelord.net/2010/08/27/logging-with-a-context-users-in-logback-and-spring-security/
 */
public class CustomPatternLayout extends PatternLayout {

    static {
        /* other */
        PatternLayout.defaultConverterMap.put(
                "session", SessionConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "user", UserConverter.class.getName());
        
    }
}