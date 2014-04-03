package org.andidev.applicationname.util;

public class ApplicationEnvironmentUtils {

    private static String APPLICATION_ENVIRONMENT = null;

    public static String getEnvironment() {
        if (APPLICATION_ENVIRONMENT == null) {
            APPLICATION_ENVIRONMENT = System.getProperty("application.environment");
        }
        return APPLICATION_ENVIRONMENT;
    }

    public static boolean isLocalhostEnvironment() {
        return "localhost".equals(getEnvironment());
    }

    public static boolean isDevelopmentEnvironment() {
        return "development".equals(getEnvironment());
    }

    public static boolean isTestEnvironment() {
        return "test".equals(getEnvironment());
    }

    public static boolean isProductionEnvironment() {
        return "production".equals(getEnvironment());
    }
}
