package ru_softlab_Malyarov_dictionary.readers;

import ru_softlab_Malyarov_dictionary.dictionary.*;
import org.springframework.stereotype.Component;
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

@Component
public class XML_Reader implements DictReader {

    public XML_Reader() {

    }


    public Dictionary read(String name) {         //метод читает XML-файл c помощью DOM-парсера
        Dictionary dict = new Dictionary();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(name));
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