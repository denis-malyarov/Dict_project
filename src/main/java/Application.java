import ru_softlab_Malyarov_dictionary.dictionary.*;
import ru_softlab_Malyarov_dictionary.DictionaryCreationFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application {
     public static int c1, c2 = 0;
     public static void main(String[] args){
         ApplicationContext appContext = new AnnotationConfigApplicationContext("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\java.SpringProject");
         //DictionaryCreationFactory factory = appContext.getBean(DictionaryCreationFactory.class);
         Dictionary dict1 = appContext.getBean(DictionaryCreationFactory.class).json_reader.read("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\resources.Dict1.json");
         Dictionary dict2 = appContext.getBean(DictionaryCreationFactory.class).xml_reader.read("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\resources.Dict2.xml");
         Dictionary dict12 = new Dictionary();

         try{
             if (dict1.getId() == dict2.getId()){
                 throw new Exception("Словари имеют одинаковый id");
             }
             else{
                 dict12.setId(dict1.getId() + dict2.getId());
             }
         }
         catch (Exception e){
             System.out.println(e);
         }


         try{
             if (dict1.getLanguageType() != dict2.getLanguageType()){
                 throw new Exception("Словари на разных языках");
             }
             else{
                 dict12.setLanguageType(dict1.getLanguageType());
             }
         }
         catch (Exception e){
             System.out.println(e);
         }

         try{
             if (dict1.getUser().equals(dict2.getUser())){
                 throw new Exception("Разные пользователи словарей");
             }
             else{
                 dict12.setUser(dict1.getUser());
             }
         }
         catch (Exception e){
             System.out.println(e);
         }

         List<Word> words = new ArrayList<>();

         Runnable task1 = new Runnable() {
             @Override
             public void run() {
                 if (c1 < dict1.getWords().size()) {
                     words.add(dict1.getWords().get(c1));
                     c1++;
                 }
             }
         };

         Runnable task2 = new Runnable() {
             @Override
             public void run(){
                 if (c2 < dict2.getWords().size()) {
                     words.add(dict2.getWords().get(c2));
                     c2++;
                 }
             }
         };

         Thread th1 = new Thread(task1);
         Thread th2 = new Thread(task2);
         while ((c1 < dict1.getWords().size()) || (c2 < dict2.getWords().size())){
             th1.start();
             th2.start();

             try{
                 th1.join();
             }
             catch (InterruptedException e){
                 System.out.println("Работа потока th1 прервана");
             }

             try{
                 th2.join();
             }
             catch (InterruptedException e){
                 System.out.println("Работа потока th2 прервана");
             }
         }

         dict12.setWords(words);
     }
}
