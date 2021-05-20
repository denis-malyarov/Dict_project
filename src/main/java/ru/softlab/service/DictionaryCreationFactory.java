package ru.softlab.service;

import org.springframework.stereotype.Component;
import ru.softlab.service.readers.Json_Reader;

/**
 * Фабрика генерации словарей включает в себя генератор словаря и парсер Json и XML файлов
 */
@Component
public class DictionaryCreationFactory {
    public Json_Reader json_reader;
    public DictionaryCreationFactory(){
        this.json_reader = new Json_Reader();
    }


}
