package oleksii.filonov.interview.misc;

import oleksii.filonov.interview.tasks.misc.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    public void test() {
        Table table = new Table();
        table.addRow(0, new ArrayList());
        assertEquals(1, table.getRowCount());
        table.addColumn(0);
        table.addColumn(1);
        assertEquals(2, table.getColumnCount());
        table.addRow(0, new ArrayList());
        assertEquals(2, table.getColumnCount());

        for (int i = 2; i < 10; i++) {
            table.addRow(i - 2, new ArrayList());
        }
        assertEquals(10, table.getRowCount());
        for (int i = 2; i < 10; i++) {
            table.addColumn(i - 2);
        }
        assertEquals(10, table.getColumnCount());

        List row = new ArrayList();
        for (int i = 0; i < 5; i++)
            row.add("Column" + i);
        String column00 = "Column00";
        row.add(0, column00);
        table.addRow(3, row);
        assertEquals(11, table.getRowCount());
        table.deleteRow(2);
        assertEquals(10, table.getRowCount());
        row = table.getRow(2);
        assertEquals(column00, row.get(0));
        for (int i = 0; i < 5; i++)
            assertEquals("Column" + i, row.get(i + 1));
        table.deleteColumn(1);
        assertEquals(9, table.getColumnCount());
        for (int i = 1; i < 5; i++)
            assertEquals("Column" + i, row.get(i));

    }

}