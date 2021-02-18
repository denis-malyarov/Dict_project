import java.util.ArrayList;
import java.util.List;

public class DictionaryCreationFactory implements DictionaryReader, DictionaryGenerator {
    private static DictionaryCreationFactory instanse;

    private DictionaryCreationFactory(){

    }

    public static DictionaryCreationFactory getInstance(){
        if (instanse == null) {
            instanse = new DictionaryCreationFactory();
        }
        return instanse;
    }

    public Dictionary read(){
        Dictionary dict = new Dictionary();
        return dict;
    }
    
    public Dictionary generate(){
        Dictionary dict = new Dictionary();
        String[] names = new String[]{"Иван", "Петр", "Сергей", "Василий", "Дмитрий", "Андрей", "Максим"};
        String[] surnames = new String[]{"Иванов", "Петров", "Сергеев", "Васильев", "Дмитриев", "Андреев", "Максимов"};
        String[][] englishWords = new String[][]{{"Cat", "Кэт", "Кошка"},
                                                 {"Dog", "Дог", "Собака"},
                                                 {"Pig", "Пиг", "Свинья"},
                                                 {"Elephant", "Элефант", "Слон"},
                                                 {"Horse", "Хорс", "Лошадь"}};
        String[][] deutshWords = new String[][] {{"Katze", "Кэтзе", "Кошка"},
                                                 {"Hund", "Ханд", "Собака"},
                                                 {"Schwein", "Швайн", "Свинья"},
                                                 {"Elefant", "Элефант", "Слон"},
                                                 {"Pferd", "Ферд", "Лошадь"}};
        if ((int) Math.random() * 2 == 0){                   // Сгенерировать язык
            dict.setLanguageType(LanguageType.DEUTSH);
        }
        else {
            dict.setLanguageType(LanguageType.ENGLISH);
        }

        String login = "", password = "";                    // Сгенерировать пользователя
        for(int i = 0; i <= 10; i++){
            login += (char) (65 + (int)Math.random()*26);
            password += (char) (65 + (int)Math.random()*26);
        }
        dict.setUser(new User(login, password, surnames[(int)Math.random()*7], names[(int)Math.random()*7]));

        int lim = (int)Math.random()*5;                      // Сгенерировать список слов
        List<Word> words = new ArrayList<Word>();
        for(int i = 0; i <= lim; i++){
            if (dict.getLanguageType() == LanguageType.DEUTSH) {
                words.add(new Word(deutshWords[i][0], deutshWords[i][2], deutshWords[i][1]));
            }
        }
        dict.setWords(words);

        return dict;
    }

}
