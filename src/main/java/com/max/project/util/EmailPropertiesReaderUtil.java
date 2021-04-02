package com.max.project.util;

import java.util.ResourceBundle;

public class EmailPropertiesReaderUtil {
    /**
     * {@link ResourceBundle} contain properties.
     */
    public static ResourceBundle resourceBundle;
    /**
     * {@link String} needed name property from app.properties.
     */
    private static final String PATH_PROPERTIES = "emailPropertiesFile";

    private EmailPropertiesReaderUtil() {
    }
    /**
     * Method that reads from file to properties value.
     */
    public static void loadProperties() {
        final String propertiesFileName = AppPropertiesReaderUtil.RESOURCE_BUNDLE.getString(PATH_PROPERTIES);
        resourceBundle = ResourceBundle.getBundle(propertiesFileName);
    }
}
