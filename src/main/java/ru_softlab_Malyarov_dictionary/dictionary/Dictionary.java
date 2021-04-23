package ru_softlab_Malyarov_dictionary.dictionary;

import java.util.List;

/**
 *  Класс словарь, модель словаря описывается пользователем, языком словаря, списком слов
 */

public class Dictionary {          // класс словарь
    private long id;                // номер словаря
    private User user;
    private LanguageType languageType;   // язык словаря
    private List<Word> words;   // список слов

    public Dictionary() {   // Конструктор по умолчанию

    }

    public User getUser() {
        return user;
    }     // получить пользователя

    public void setUser(User user) {
        this.user = user;
    } // установить значение "пользователь"

    public long getId() {  // получить ID
        return id;
    }      // получить ID

    public void setId(long id) { //установить ID
        this.id = id;
    }   // установить значение ID

    public LanguageType getLanguageType() {  // Получить язык словаря
        return languageType;
    }  // Получить язык

    public void setLanguageType(LanguageType languageType) {  // Установить язык словаря
        this.languageType = languageType;
    } // установить язык

    public List<Word> getWords() {  // получить список слов
        return words;
    }   // получить список слов

    public void setWords(List<Word> words) {   // Установить список слов
        this.words = words;
    }  // установить список слов
}
