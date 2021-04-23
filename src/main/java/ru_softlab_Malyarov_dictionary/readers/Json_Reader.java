package ru_softlab_Malyarov_dictionary.readers;

import ru_softlab_Malyarov_dictionary.dictionary.Dictionary;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class Json_Reader implements DictReader {

    public Json_Reader(){

    }


    public Dictionary read(String name) {   // метод читает Json файл
        Dictionary dict = new Dictionary();
        ObjectMapper mapper = new ObjectMapper();

        try{
            dict = mapper.readValue(new File(name), Dictionary.class);
        }
        catch(IOException e){
            e.getMessage();
        }

        return dict;
    }
}
