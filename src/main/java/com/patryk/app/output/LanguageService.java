package com.patryk.app.output;

import java.util.*;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to provide diffrent language versions of application
 * which uses .properties files to load given String
 * deafault language is English
 */
public class LanguageService {

    private ResourceBundle resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale("eng", "ENG"));

    void setLanguageVersion(String languageCode, String countryCode) {
        resourceBundleInstance = ResourceBundle.getBundle("OX", new Locale(languageCode, countryCode));
    }

    ResourceBundle getResourceBundleInstance() {
        return resourceBundleInstance;
    }
}
