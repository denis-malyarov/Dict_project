package Dictionary;

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