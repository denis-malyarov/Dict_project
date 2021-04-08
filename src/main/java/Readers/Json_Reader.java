package Readers;

import Dictionary.Dictionary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Json_Reader implements DictReader {
    private static Json_Reader instanse;

    private Json_Reader(){

    }

    public static Json_Reader getInstance(){    // Реализовани как Singleton
        if (instanse == null) {
            instanse = new Json_Reader();
        }
        return instanse;
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
