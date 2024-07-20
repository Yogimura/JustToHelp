package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.Parser;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.Addable;

public class ParseStrategy implements Addable<String> {
    Parser parser = new Parser();
    @Override
    public Group create(String string) {
        return parser.parse(string);
    }
}
