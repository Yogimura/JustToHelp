package Sudoku.SumsOGroups.Factories.iterateFactory;

import Sudoku.SumsOGroups.SizeStrategies.size2strategy;
import Sudoku.SumsOGroups.SizeStrategies.size3strategy;
import Sudoku.SumsOGroups.SizeStrategies.size4strategy;
import Sudoku.SumsOGroups.SizeStrategies.size5strategy;
import Sudoku.SumsOGroups.Types.Iterate;

public class iterateStrategyFactory {
    public static Iterate<Integer> create(int size) {
        switch (size) {
            case 2 -> {
                return new size2strategy();
            }

            case 3 -> {
                return new size3strategy();
            }

            case 4 -> {
                return new size4strategy();
            }

            case 5 -> {
                return new size5strategy();
            }

            default -> {
                return null;
            }
        }
    }
}
