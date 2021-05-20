package ru.softlab.service.model;

/**
 * Тип перечисление, представляет собой язык словаря
 */
public enum LanguageType {
    ENGLISH,
    DEUTSH;

    public String getStatus() {
        return this.name();
    }
}