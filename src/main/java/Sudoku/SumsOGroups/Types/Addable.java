package Sudoku.SumsOGroups.Types;

import Sudoku.SumsOGroups.POJO.Group;

public interface Addable<T> {
    Group create(T t);
}
