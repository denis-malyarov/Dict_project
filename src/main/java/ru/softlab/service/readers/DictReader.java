package ru.softlab.service.readers;

import ru.softlab.service.model.Dictionary;

public interface DictReader {
    public Dictionary read(String name);
}
