package com.patryk.app.services;

import java.util.Objects;
import java.util.Optional;

/**
 * @author Patryk Kucharski
 *
 * Service to provide diffrent language versions of application
 */
public class LanguageService {

    String languageVersion;

    public LanguageService(String languageVersion){
        this.languageVersion = languageVersion;
    }

    public void setLanguageVersion(String languageVersion) {
        Optional<String> optional = Optional.ofNullable(languageVersion);
        if (optional.isPresent()) {
            this.languageVersion = languageVersion;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageService that = (LanguageService) o;
        return Objects.equals(languageVersion, that.languageVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageVersion);
    }
}
