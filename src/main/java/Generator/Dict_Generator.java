package Generator;

import Dictionary.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, генерирующий словарь случайным образом из заранее известных данных
 */
public class Dict_Generator implements DictionaryGenerator {

    private  static Dict_Generator instanse;

    private Dict_Generator(){

    }

    public static Dict_Generator getInstance(){          // реализован как Singleton
        if (instanse == null){
            instanse = new Dict_Generator();
        }
        return instanse;
    }

     // собственно генерация словаря
    public Dictionary generate(){
        Dictionary dict = new Dictionary();
        dict.setId((long)Math.random()*100000);
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
        dict.setUser(new User((long)Math.random()*100000,login, password, surnames[(int)Math.random()*7], names[(int)Math.random()*7]));

        int lim = (int)Math.random()*5;                      // Сгенерировать список слов
        List<Word> words = new ArrayList<Word>();
        for(int i = 0; i <= lim; i++){
            if (dict.getLanguageType() == LanguageType.DEUTSH) {
                words.add(new Word((long)(i+1), deutshWords[i][0], deutshWords[i][2], deutshWords[i][1]));
            }
            else{
                words.add( new Word((long)(i+11),englishWords[i][0], englishWords[i][2], englishWords[i][1]));
            }
        }
        dict.setWords(words);

        return dict;
    }

}
