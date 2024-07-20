package Sudoku.SumsOGroups.Types;

import java.util.List;
import java.util.Set;

public interface Iterate<T> {
    Set<T> iterateThrough(List<List<T>> values, Integer finals);
}
