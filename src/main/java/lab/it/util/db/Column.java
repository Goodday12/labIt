package lab.it.util.db;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class Column {

    public List<Cell> cells;
    String name;

    public Column(@JsonProperty(value = "cells") List<Cell> cells, @JsonProperty(value = "name") String name) {
        this.cells = cells;
        this.name = name;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Column)) return false;
        Column column = (Column) o;
        return getCells().equals(column.getCells());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCells());
    }
}
