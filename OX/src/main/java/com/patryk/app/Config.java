package com.patryk.app;

import java.util.Objects;

/**
 * @author Patryk Kucharski
 */
public class Config {

    String languageVersion;
    BoardConfig boardConfig = new BoardConfig();

    Config(String languageVersion){
        this.languageVersion = languageVersion;
    }
    Config(){
    }//TODO potrzebuje tego konstruktora?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return Objects.equals(languageVersion, config.languageVersion) &&
                Objects.equals(boardConfig, config.boardConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageVersion, boardConfig);
    }


    public Config setConfig(String language) {
        return new Config(language);
    }

}
