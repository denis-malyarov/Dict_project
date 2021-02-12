public class Word {
    static private long wordCount;  // количество слов
    private Long id;     // ID слова
    private String sNative;  // Собственно слово
    private String translation;  // Перевод
    private String transcription; // Транскрипция

    static {
        wordCount = 0;
    }

    public Word(String sNative, String translation, String transcription) {  // конструктор слова
        wordCount += 1;
        setId(wordCount);
        setsNative(sNative);
        setTranslation(translation);
        setTranscription(transcription);
    }

    public Long getId() {   // получить ID
        return id;
    }

    private void setId(Long id) {  // установить ID - метод недоступен вне класса
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
