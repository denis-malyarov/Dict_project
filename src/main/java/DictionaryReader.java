import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface DictionaryReader {
    public Dictionary readJson(String name) throws IOException;
    public Dictionary readXML_DOM(String name) throws ParserConfigurationException, SAXException, IOException;
    public Dictionary readXML_SAX(String name) throws ParserConfigurationException, SAXException, IOException;
    public Dictionary readXML_JAXB(String name);
}
