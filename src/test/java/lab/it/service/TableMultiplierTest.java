package lab.it.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.it.util.db.Cell;
import lab.it.util.db.Column;
import lab.it.util.db.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableMultiplierTest {

    @Test
    void multiplyTables() {
        Cell cell = new Cell(1);
        Cell cell1 = new Cell(2);
        List<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell1);
        Column column = new Column(cells, "ABC");
        List<Column> columns = new ArrayList<>();
        columns.add(column);
        Table table = new Table(columns, "Main table");

        Cell cell2 = new Cell(3);
        Cell cell3 = new Cell(4);
        List<Cell> cells1 = new ArrayList<>();
        cells1.add(cell2);
        cells1.add(cell3);
        Column column1 = new Column(cells1, "ZXC");
        List<Column> columns1 = new ArrayList<>();
        columns1.add(column1);
        Table table1 = new Table(columns1, "Main table");

        Table multiplyTables = TableMultiplier.multiplyTables(table, table1);
        String s = new String();

        try {
            s = new ObjectMapper().writeValueAsString(multiplyTables);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            Table table2 = new ObjectMapper().readValue(s, Table.class);
            assertEquals(table2, multiplyTables);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}