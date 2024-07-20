package Sudoku.SumsOGroups;

import java.util.Set;

public class StrategyManager {
    public static Set<Integer> run(Group gp) {
        Iterate<Integer> iterator = iterateStrategyFactory.create(gp.getSize());
        assert iterator != null;
        return iterator.iterateThrough(gp.getOptionValues(), gp.getFullValue());
    }
}
