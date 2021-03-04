import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class DictionaryCreationFactoryTest {

//    @Before
//    public void setUp(){
//        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
//        Dictionary expDict = dictBuilder.readJson("Dict1.json");
//    }

    @Test
    void readJson_EQ_ID() throws IOException {
        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = dictBuilder.readJson("Dict1.json");
        Assertions.assertEquals(expDict.getId(), 1);
    }

    @Test
    void readJson_EQ_LANGUAGETYPE() throws IOException {
        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = dictBuilder.readJson("Dict1.json");
        Assertions.assertEquals(expDict.getLanguageType(), LanguageType.ENGLISH);
    }

    @Test
    void readJson_EQ_USER() throws IOException {
        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = dictBuilder.readJson("Dict1.json");
        Assertions.assertTrue((expDict.getUser().getId() == 1) &&
                                       (expDict.getUser().getLogin() == "login1") &&
                                       (expDict.getUser().getPassword() == "password1") &&
                                       (expDict.getUser().getSurname() == "Ivanov") &&
                                       (expDict.getUser().getFirstName() == "Ivan"));
    }

//    @Test
//    void readJson_EQ_WORDS() throws IOException {
//        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
//        Dictionary expDict = dictBuilder.readJson("Dict1.json");
//        Assertions.assertEquals(expDict.getId(), 1);
//    }
//
//    @Test
//    void generate() {
//    }
}