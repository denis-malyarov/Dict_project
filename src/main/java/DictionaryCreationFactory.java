import Generator.Dict_Generator;
import Readers.Dict_Reader;

/**
 * Фабрика генерации словарей включает в себя генератор словаря и парсер Json и XML файлов
 */
public class DictionaryCreationFactory {
    public Dict_Generator generator;
    public Dict_Reader reader;
    private static DictionaryCreationFactory instanse;
    private DictionaryCreationFactory(){

    }

    public static DictionaryCreationFactory getInstance(){       // реализован как Singleton
        if (instanse == null) {
            instanse = new DictionaryCreationFactory();
            instanse.generator = Dict_Generator.getInstance();
            instanse.reader = Dict_Reader.getInstance();
        }
        return instanse;
    }




//    public Dictionary readJson(String name) {
//        Dictionary dict = new Dictionary();
//        ObjectMapper mapper = new ObjectMapper();
//
//        try{
//            dict = mapper.readValue(new File(name), Dictionary.class);
//        }
//        catch(IOException e){
//            e.getMessage();
//        }
//
//        return dict;
//    }

//    public Dictionary readXML_DOM(String name) {//throws ParserConfigurationException, SAXException, IOException{
//        Dictionary dict = new Dictionary();
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(new File("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.xml"));
//            Node xmlDict = document.getDocumentElement();
//            NamedNodeMap dictAtt = xmlDict.getAttributes();
//            dict.setId(Long.parseLong(dictAtt.getNamedItem("id").getNodeValue()));
//            if (dictAtt.getNamedItem("id").getNodeValue().equals("ENGLISH")) {
//                dict.setLanguageType(LanguageType.ENGLISH);
//            }
//
//            else {
//                dict.setLanguageType(LanguageType.DEUTSH);
//            }
//
//            Node user = document.getDocumentElement().getElementsByTagName("user").item(0);
//            NamedNodeMap userAtt = user.getAttributes();
//
//            dict.setUser(new User(Long.parseLong(userAtt.getNamedItem("id").getNodeValue()),
//                    userAtt.getNamedItem("login").getNodeValue(),
//                    userAtt.getNamedItem("password").getNodeValue(),
//                    userAtt.getNamedItem("surname").getNodeValue(),
//                    userAtt.getNamedItem("firstName").getNodeValue()));
//
//
//            NodeList xmlWords = document.getDocumentElement().getElementsByTagName("word");
//            List<Word> words = new ArrayList<Word>();
//
//            for(int i = 0; i < xmlWords.getLength(); i++){
//                Node word = xmlWords.item(i);
//                NamedNodeMap attributes = word.getAttributes();
//                words.add(new Word(Long.parseLong(attributes.getNamedItem("id").getNodeValue()),
//                        attributes.getNamedItem("sNative").getNodeValue(),
//                        attributes.getNamedItem("translation").getNodeValue(),
//                        attributes.getNamedItem("transcription").getNodeValue()));
//            }
//
//            dict.setWords(words);
//        }
//
//        catch(ParserConfigurationException| SAXException|IOException e){
//            e.getMessage();
//        }
//
//        return dict;
//    }


//    public Dictionary readXML_SAX(String name) throws ParserConfigurationException, SAXException, IOException {
//        Dictionary dict = new Dictionary();
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        return dict;
//    }
//
//
//    public Dictionary readXML_JAXB(String name) {
//        return null;
//    }


//    public Dictionary generate(){
//        Dictionary dict = new Dictionary();
//        String[] names = new String[]{"Иван", "Петр", "Сергей", "Василий", "Дмитрий", "Андрей", "Максим"};
//        String[] surnames = new String[]{"Иванов", "Петров", "Сергеев", "Васильев", "Дмитриев", "Андреев", "Максимов"};
//        String[][] englishWords = new String[][]{{"Cat", "Кэт", "Кошка"},
//                                                 {"Dog", "Дог", "Собака"},
//                                                 {"Pig", "Пиг", "Свинья"},
//                                                 {"Elephant", "Элефант", "Слон"},
//                                                 {"Horse", "Хорс", "Лошадь"}};
//        String[][] deutshWords = new String[][] {{"Katze", "Кэтзе", "Кошка"},
//                                                 {"Hund", "Ханд", "Собака"},
//                                                 {"Schwein", "Швайн", "Свинья"},
//                                                 {"Elefant", "Элефант", "Слон"},
//                                                 {"Pferd", "Ферд", "Лошадь"}};
//        if ((int) Math.random() * 2 == 0){                   // Сгенерировать язык
//            dict.setLanguageType(LanguageType.DEUTSH);
//        }
//        else {
//            dict.setLanguageType(LanguageType.ENGLISH);
//        }
//
//        String login = "", password = "";                    // Сгенерировать пользователя
//        for(int i = 0; i <= 10; i++){
//            login += (char) (65 + (int)Math.random()*26);
//            password += (char) (65 + (int)Math.random()*26);
//        }
//        dict.setUser(new User((long)Math.random()*100000,login, password, surnames[(int)Math.random()*7], names[(int)Math.random()*7]));
//
//        int lim = (int)Math.random()*5;                      // Сгенерировать список слов
//        List<Word> words = new ArrayList<Word>();
//        for(int i = 0; i <= lim; i++){
//            if (dict.getLanguageType() == LanguageType.DEUTSH) {
//                words.add(new Word((long)(i+1), deutshWords[i][0], deutshWords[i][2], deutshWords[i][1]));
//            }
//            else{
//                words.add( new Word((long)(i+11),englishWords[i][0], englishWords[i][2], englishWords[i][1]));
//            }
//        }
//        dict.setWords(words);
//
//        return dict;
//    }

}
