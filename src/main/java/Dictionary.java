import java.util.List;

public class Dictionary {          // класс словарь
    private static long dictCount;  // количество созданных объектов
    private long id;                // номер словаря
    private User user;
    private LanguageType languageType;   // язык словаря
    private List<Word> words;   // список слов

    static {
        dictCount = 0;
    }

    public Dictionary() {   // Конструктор по умолчанию
        dictCount += 1;
        setId(dictCount);
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

    private void setId(long id) { //установить ID
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
