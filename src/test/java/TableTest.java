import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab.it.util.db.Cell;
import lab.it.util.db.Column;
import lab.it.util.db.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TableTest {

    @Test
    public void testTable(){
        Cell cell = new Cell(1);
        Cell cell1 = new Cell(2);
        List<Cell> cells = new ArrayList<>();
        cells.add(cell);
        cells.add(cell1);
        Column column = new Column(cells, "ABC");
        List<Column> columns = new ArrayList<>();
        columns.add(column);
        Table table = new Table(columns, "Main table");




        try {
            String json = new ObjectMapper().writeValueAsString(table);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
