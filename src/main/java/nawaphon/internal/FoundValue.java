package nawaphon.internal;


import java.util.Objects;

public class FoundValue {

    private final int value;

    public FoundValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FoundValue that = (FoundValue) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int getValue() {
        return value;
    }
}
