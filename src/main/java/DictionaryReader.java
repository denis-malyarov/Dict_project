import java.io.IOException;

public interface DictionaryReader {
    public Dictionary readJson(String name) throws IOException;
//    public Dictionary readXML(String name);
}
