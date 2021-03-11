import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DictionaryCreationFactory implements DictionaryReader, DictionaryGenerator {
    private static DictionaryCreationFactory instanse;

//    private static class XMLHandler extends DefaultHandler {
//        @Override
//        public void startDocument() throws SAXException {
//            // Тут будет логика реакции на начало документа
//        }
//
//        @Override
//        public void endDocument() throws SAXException {
//            // Тут будет логика реакции на конец документа
//        }
//
//        @Override
//        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            // Тут будет логика реакции на начало элемента
//        }
//
//        @Override
//        public void endElement(String uri, String localName, String qName) throws SAXException {
//            // Тут будет логика реакции на конец элемента
//        }
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            // Тут будет логика реакции на текст между элементами
//        }
//
//        @Override
//        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
//            // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
//        }
//    }


    private DictionaryCreationFactory(){

    }

    public static DictionaryCreationFactory getInstance(){
        if (instanse == null) {
            instanse = new DictionaryCreationFactory();
        }
        return instanse;
    }

    public Dictionary readJson(String name) throws IOException {
        Dictionary dict = new Dictionary();
        ObjectMapper mapper = new ObjectMapper();
        dict = mapper.readValue(new File(name), Dictionary.class);
        return dict;
    }

    public Dictionary readXML_DOM(String name) throws ParserConfigurationException, SAXException, IOException{
        Dictionary dict = new Dictionary();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
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

        return dict;
    }


    public Dictionary readXML_SAX(String name) throws ParserConfigurationException, SAXException, IOException {
        Dictionary dict = new Dictionary();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        return dict;
    }


    public Dictionary readXML_JAXB(String name) {
        return null;
    }


    public Dictionary generate(){
        Dictionary dict = new Dictionary();
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
