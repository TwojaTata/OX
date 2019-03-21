package com.patryk.app.output;

import java.util.*;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to provide diffrent language versions of application
 */
public class LanguageService {

    private ResourceBundle resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale("pl", "PL"));

    ResourceBundle getResourceBundleInstance() {
        return resourceBundleInstance;
    }

    void setLanguageVersion(String languageCode, String countryCode) {
        resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale(languageCode, countryCode));
    }
}
