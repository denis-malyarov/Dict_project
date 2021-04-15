package SpringProject;

import SpringProject.Generator.Dict_Generator;
import SpringProject.Readers.Json_Reader;
import SpringProject.Readers.XML_Reader;
import org.springframework.stereotype.Component;

/**
 * Фабрика генерации словарей включает в себя генератор словаря и парсер Json и XML файлов
 */
@Component
public class DictionaryCreationFactory {
    public Dict_Generator generator;
    public Json_Reader json_reader;
    public XML_Reader xml_reader;
    private static DictionaryCreationFactory instanse;
    private DictionaryCreationFactory(){

    }

    public static DictionaryCreationFactory getInstance(){       // реализован как Singleton
        if (instanse == null) {
            instanse = new DictionaryCreationFactory();
            instanse.generator = Dict_Generator.getInstance();
            instanse.json_reader = Json_Reader.getInstance();
            instanse.xml_reader = XML_Reader.getInstance();
        }
        return instanse;
    }

}
