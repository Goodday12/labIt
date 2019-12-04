package lab.it.util.db;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;
import java.util.Objects;

@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.ANY)
public class Table {

    private List<Column> table;
    private String name;

    public Table(@JsonProperty(value = "columns") List<Column> table, @JsonProperty(value = "name") String name) {
        this.table = table;
        this.name = name;
    }

    public List<Column> getTable() {
        return table;
    }

    public void setTable(List<Column> table) {
        this.table = table;
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
        if (!(o instanceof Table)) return false;
        Table table1 = (Table) o;
        return getTable().equals(table1.getTable());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTable());
    }
}
