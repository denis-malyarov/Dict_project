import java.io.Serializable;

public enum LanguageType implements Serializable {
    ENGLISH,
    DEUTSH;

    public String getStatus() {
        return this.name();
    }
}