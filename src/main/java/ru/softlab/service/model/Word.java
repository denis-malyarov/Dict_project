package ru.softlab.service.model;

/**
 * Класс-слово, хранит транскрипцию и перевод, а также само слово
 */
public class Word {
    private Long id;     // ID слова
    private String sNative;  // Собственно слово
    private String translation;  // Перевод
    private String transcription; // Транскрипция

    public  Word(){

    }

    public Word(Long id, String sNative, String translation, String transcription) {  // конструктор слов;
        setId(id);
        setsNative(sNative);
        setTranslation(translation);
        setTranscription(transcription);
    }

    public long getId() {   // получить ID
        return id;
    }

    public void setId(Long id) {  // установить ID - метод недоступен вне класса
        this.id = id;
    }

    public String getsNative() {  // получить написание слова
        return sNative;
    }

    public void setsNative(String sNative) {   // установить написание слова
        this.sNative = sNative;
    }

    public String getTranslation() {  // получить перевод слова
        return translation;
    }

    public void setTranslation(String translation) {  // установить перевод слова
        this.translation = translation;
    }

    public String getTranscription() {   // получить транскрипцию
        return transcription;
    }

    public void setTranscription(String transcription) {  // установить транскрипцию
        this.transcription = transcription;
    }
}

