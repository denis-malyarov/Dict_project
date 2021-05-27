package ru.softlab.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.softlab.service.DictionaryCreationFactory;
import ru.softlab.service.readers.Json_Reader;
import ru.softlab.service.model.Dictionary;

/**
 * Контроллер работы со справочниками
 */
@Controller
public class DictionaryController {

    private final DictionaryCreationFactory dictionaryFactory;

    public DictionaryController(DictionaryCreationFactory dictionaryFactory) {
        this.dictionaryFactory = dictionaryFactory;
    }

    @GetMapping("/")
    public ModelAndView showForm() {
        //ModelAndView modelAndView = new ModelAndView();
        Json_Reader reader = new Json_Reader();
       // modelAndView.setViewName("list");
        Dictionary dictionary = reader.read("C:\\Users\\Денис\\dictionary\\src\\main\\resources\\Dict1.json");
       // modelAndView.addObject("dictionary", dictionary);
        return new ModelAndView("list", "dictionary", dictionary);
    }
}
