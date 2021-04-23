package ru_softlab_Malyarov_dictionary.readers;

import ru_softlab_Malyarov_dictionary.dictionary.Dictionary;

public interface DictReader {
    public Dictionary read(String name);
}
