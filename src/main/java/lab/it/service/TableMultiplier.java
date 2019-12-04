package lab.it.service;

import lab.it.util.db.Column;
import lab.it.util.db.Table;

import java.util.ArrayList;

public class TableMultiplier {

    public static Table multiplyTables(Table t1, Table t2){
        Table table = new Table( new ArrayList<>(), "Multiply " + t1.getName() + " and " + t2.getName() );
        for (Column column : t1.getTable()) {
            table.getTable().add(new Column( new ArrayList<>(),column.getName()));
        }
        for (Column column : t2.getTable()) {
            table.getTable().add(new Column(new ArrayList<>(), column.getName()));
        }
        //union all with all
        int len2 = t1.getTable().get(0).getCells().size();
        int len1 = t2.getTable().get(0).getCells().size();

        for (int i = 0; i < len1; i++) {
            for (int i1 = 0; i1 < len2; i1++) {
                for (int i2 = 0; i2 < t1.getTable().size(); i2++) {
                    table.getTable().get(i2).getCells().add(t1.getTable().get(i2).getCells().get(i));
                }
                for (int i2 = 0; i2 < t2.getTable().size(); i2++) {
                    table.getTable().get(i2 + t1.getTable().size()).getCells().add(t2.getTable().get(i2).getCells().get(i1));
                }
            }
        }
        return table;
    }

}
