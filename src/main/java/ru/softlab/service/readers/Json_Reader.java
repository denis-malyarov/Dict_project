package ru.softlab.service.readers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.softlab.service.model.Dictionary;

import java.io.File;
import java.io.IOException;

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
