import Dictionary.Dictionary;
import Dictionary.LanguageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Dict_ReaderTest {

//    @Before
//    public void setUp(){
//        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
//        Dictionary.Dictionary expDict = dictBuilder.readJson("Dict1.json");
//    }

    @Test
    void readJson_EQ_ID() {
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readJson("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertEquals(expDict.getId(), 1);
    }

    @Test
    void readJson_EQ_LANGUAGETYPE() {
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readJson("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertEquals(expDict.getLanguageType(), LanguageType.ENGLISH);
    }

    @Test
    void readJson_EQ_USER(){
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readJson("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertTrue((expDict.getUser().getId() == 1) &&
                (expDict.getUser().getLogin().equals("login1")) &&
                (expDict.getUser().getPassword().equals("password1")) &&
                (expDict.getUser().getSurname().equals("Ivanov")) &&
                (expDict.getUser().getFirstName().equals("Ivan")));
    }

    @Test
    void readXML_DOM_EQ_ID(){
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readXML_DOM("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.xml");
        Assertions.assertEquals(expDict.getId(), 1);
    }

    @Test
    void readXML_DOM_EQ_LANGUAGETYPE() {
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readXML_DOM("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.xml");
        Assertions.assertEquals(expDict.getLanguageType(), LanguageType.ENGLISH);
    }

    @Test
    void readXML_DOM_EQ_USER(){
        Dict_Reader reader = Dict_Reader.getInstance();
        Dictionary expDict = reader.readXML_DOM("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.xml");
        Assertions.assertTrue((expDict.getUser().getId() == 1) &&
                (expDict.getUser().getLogin().equals("login1")) &&
                (expDict.getUser().getPassword().equals("password1")) &&
                (expDict.getUser().getSurname().equals("Ivanov")) &&
                (expDict.getUser().getFirstName().equals("Ivan")));
    }
}