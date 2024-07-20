package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.Addable;

public class ConstructorStrategy implements Addable<baseGroup> {

    @Override
    public Group create(baseGroup baseGroup) {
        return new Group(baseGroup.fullValue(), baseGroup.size(), baseGroup.options());
    }
}
