package nawaphon.internal;


import java.util.Objects;

public class FoundKey {

    private final String key;

    public FoundKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FoundKey foundKey = (FoundKey) o;
        return Objects.equals(key, foundKey.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}
