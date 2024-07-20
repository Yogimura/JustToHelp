package Sudoku.SumsOGroups;

import java.util.List;
import java.util.Set;

public interface Iterate<T> {
    Set<T> iterateThrough(List<T> t, Integer i);
}
