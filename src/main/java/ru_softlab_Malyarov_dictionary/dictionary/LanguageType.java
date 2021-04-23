package ru_softlab_Malyarov_dictionary.dictionary;
import java.io.Serializable;

/**
 * Тип перечисление, представляет собой язык словаря
 */
public enum LanguageType implements Serializable {
    ENGLISH,
    DEUTSH;

    public String getStatus() {
        return this.name();
    }
}