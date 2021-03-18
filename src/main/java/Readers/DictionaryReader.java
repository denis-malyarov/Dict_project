package Readers;

import Dictionary.Dictionary;

public interface DictionaryReader {      // чтение из файла
    public Dictionary readJson(String name);    // метод для чтения Json
    public Dictionary readXML_DOM(String name);  // метод для чтения XML(DOM-парсер)
}
