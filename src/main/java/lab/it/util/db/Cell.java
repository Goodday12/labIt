package lab.it.util.db;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class Cell {

    private Integer value;

    public Cell(@JsonProperty(value = "value") Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return getValue().equals(cell.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
