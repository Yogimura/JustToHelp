package Sudoku.SumsOGroups.Controllers;

import Sudoku.SumsOGroups.Factories.iterateFactory.iterateStrategyFactory;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.Iterate;

import java.util.Set;

public class StrategyManager {
    public static Set<Integer> run(Group gp) {
        Iterate<Integer> iterator = iterateStrategyFactory.create(gp.getSize());
        assert iterator != null;
        return iterator.iterateThrough(gp.getOptionValues(), gp.getFullValue());
    }
}
