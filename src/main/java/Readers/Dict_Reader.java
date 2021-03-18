package Readers;

import Dictionary.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Класс, позволяющий парсить XML и Json файлы в словарь Dictionary
 */
public class Dict_Reader implements DictionaryReader {


    private static Dict_Reader instanse;

    private Dict_Reader(){

    }

    public static Dict_Reader getInstance(){    // Реализовани как Singleton
        if (instanse == null) {
            instanse = new Dict_Reader();
        }
        return instanse;
    }


    public Dictionary readJson(String name) {   // метод читает Json файл
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


    public Dictionary readXML_DOM(String name) {         //метод читает XML-файл c помощью DOM-парсера
        Dictionary dict = new Dictionary();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.xml"));
            Node xmlDict = document.getDocumentElement();
            NamedNodeMap dictAtt = xmlDict.getAttributes();
            dict.setId(Long.parseLong(dictAtt.getNamedItem("id").getNodeValue()));
            if (dictAtt.getNamedItem("id").getNodeValue().equals("ENGLISH")) {
                dict.setLanguageType(LanguageType.ENGLISH);
            }

            else {
                dict.setLanguageType(LanguageType.DEUTSH);
            }

            Node user = document.getDocumentElement().getElementsByTagName("user").item(0);
            NamedNodeMap userAtt = user.getAttributes();

            dict.setUser(new User(Long.parseLong(userAtt.getNamedItem("id").getNodeValue()),
                    userAtt.getNamedItem("login").getNodeValue(),
                    userAtt.getNamedItem("password").getNodeValue(),
                    userAtt.getNamedItem("surname").getNodeValue(),
                    userAtt.getNamedItem("firstName").getNodeValue()));


            NodeList xmlWords = document.getDocumentElement().getElementsByTagName("word");
            List<Word> words = new ArrayList<Word>();

            for(int i = 0; i < xmlWords.getLength(); i++){
                Node word = xmlWords.item(i);
                NamedNodeMap attributes = word.getAttributes();
                words.add(new Word(Long.parseLong(attributes.getNamedItem("id").getNodeValue()),
                        attributes.getNamedItem("sNative").getNodeValue(),
                        attributes.getNamedItem("translation").getNodeValue(),
                        attributes.getNamedItem("transcription").getNodeValue()));
            }

            dict.setWords(words);
        }

        catch(ParserConfigurationException | SAXException |IOException e){
            e.getMessage();
        }

        return dict;
    }

}
