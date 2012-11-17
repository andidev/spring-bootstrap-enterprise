package org.andidev.logging.logback;

import ch.qos.logback.classic.PatternLayout;
import org.andidev.logging.logback.colors.*;

/**
 *
 * @author anders
 * 
 * see http://www.codelord.net/2010/08/27/logging-with-a-context-users-in-logback-and-spring-security/
 */
public class CustomPatternLayout extends PatternLayout {

    static {
        /* colora */
        PatternLayout.defaultConverterMap.put(
                "colorblack", ColorBlackConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorblue", ColorBlueConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorcyan", ColorCyanConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorgreen", ColorGreenConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorlevel", ColorLevelConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "coloroff", ColorOffConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorpurple", ColorPurpleConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorred", ColorRedConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "colorwhite", ColorWhiteConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "coloryellow", ColorYellowConverter.class.getName());
        
        /* other */
        PatternLayout.defaultConverterMap.put(
                "session", SessionConverter.class.getName());
        PatternLayout.defaultConverterMap.put(
                "user", UserConverter.class.getName());
        
    }
}