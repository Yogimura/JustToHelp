package Sudoku.SumsOGroups;

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

            default -> {
                return null;
            }
        }
    }
}
