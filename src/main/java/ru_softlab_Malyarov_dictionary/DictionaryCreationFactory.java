package ru_softlab_Malyarov_dictionary;

import ru_softlab_Malyarov_dictionary.generator.Dict_Generator;
import ru_softlab_Malyarov_dictionary.readers.Json_Reader;
import ru_softlab_Malyarov_dictionary.readers.XML_Reader;
import org.springframework.stereotype.Component;

/**
 * Фабрика генерации словарей включает в себя генератор словаря и парсер Json и XML файлов
 */
@Component
public class DictionaryCreationFactory {
    public Dict_Generator generator;
    public Json_Reader json_reader;
    public XML_Reader xml_reader;
    public DictionaryCreationFactory(){
        this.generator = new Dict_Generator();
        this.json_reader = new Json_Reader();
        this.xml_reader = new XML_Reader();
    }


}
