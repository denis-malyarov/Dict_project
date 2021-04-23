import SpringProject.Dictionary.*;
import SpringProject.DictionaryCreationFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

class DictionaryCreationFactoryTest {

//    @Before
//    public void setUp(){
//        DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
//        Dictionary.Dictionary expDict = dictBuilder.readJson("Dict1.json");
//    }

    @Test
    void readJson_EQ_ID() throws IOException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\java.SpringProject");
        //DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = appContext.getBean(DictionaryCreationFactory.class).json_reader.read("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertEquals(expDict.getId(), 1);
    }

    @Test
    void readJson_EQ_LANGUAGETYPE() throws IOException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\java.SpringProject");
        //DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = appContext.getBean(DictionaryCreationFactory.class).json_reader.read("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertEquals(expDict.getLanguageType(), LanguageType.ENGLISH);
    }

    @Test
    void readJson_EQ_USER() throws IOException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\java.SpringProject");
        //DictionaryCreationFactory dictBuilder = DictionaryCreationFactory.getInstance();
        Dictionary expDict = appContext.getBean(DictionaryCreationFactory.class).json_reader.read("C:\\Users\\Денис\\cloned_dictionary\\src\\test\\resources\\Dict1.json");
        Assertions.assertTrue((expDict.getUser().getId() == 1) &&
                (expDict.getUser().getLogin().equals("login1")) &&
                (expDict.getUser().getPassword().equals("password1")) &&
                (expDict.getUser().getSurname().equals("Ivanov")) &&
                (expDict.getUser().getFirstName().equals("Ivan")));
    }

}