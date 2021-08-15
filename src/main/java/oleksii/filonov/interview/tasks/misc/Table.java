package oleksii.filonov.interview.tasks.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mimic Relation table
 */
public class Table<T> implements Iterable<List<T>> {

    private List<T> columns = new ArrayList<>();
    private List<List<T>> rows = new ArrayList<>();

    public void addRow(int index, List<T> row) {
        while(row.size() < columns.size()) {
            row.add((T) new Object());
        }
        rows.add(index, row);
    }

    public List<T> getRow(int index) {
        return rows.get(index);
    }

    public void addColumn(int index) {
        columns.add(index, (T) new Object());
        rows.forEach(row -> row.add(index, (T) new Object()));
    }

    public void deleteRow(int index) {
        rows.remove(index);
    }

    public void deleteColumn(int index) {
        rows.forEach(row -> row.remove(index));
    }

    public int getColumnCount() {
        return rows.get(0).size();
    }

    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new TableIterator();
    }

    private class TableIterator implements Iterator<List<T>> {

        private int curIndex = 0;

        @Override
        public boolean hasNext() {
            return curIndex < rows.size() - 1;
        }

        @Override
        public List<T> next() {
            List<T> result = rows.get(curIndex);
            curIndex++;
            return result;
        }
    }
}
