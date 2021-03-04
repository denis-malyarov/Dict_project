import java.util.List;

public class Dictionary {          // класс словарь
    private long id;                // номер словаря
    private User user;
    private LanguageType languageType;   // язык словаря
    private List<Word> words;   // список слов

    public Dictionary() {   // Конструктор по умолчанию

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {  // получить ID
        return id;
    }

    public void setId(long id) { //установить ID
        this.id = id;
    }

    public LanguageType getLanguageType() {  // Получить язык словаря
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {  // Установить язык словаря
        this.languageType = languageType;
    }

    public List<Word> getWords() {  // получить список слов
        return words;
    }

    public void setWords(List<Word> words) {   // Установить список слов
        this.words = words;
    }
}
