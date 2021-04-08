import Dictionary.*;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
     public static void main(String[] args){
         DictionaryCreationFactory factory = DictionaryCreationFactory.getInstance();
         Dictionary dict1 = factory.json_reader.read("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\resources.Dict1.json");
         Dictionary dict2 = factory.xml_reader.read("C:\\Users\\Денис\\Desktop\\dictionary\\src\\main\\resources.Dict2.xml");
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
         int c1, c2 = 0;
         
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
