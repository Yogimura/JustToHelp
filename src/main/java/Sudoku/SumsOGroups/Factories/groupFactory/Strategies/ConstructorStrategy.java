package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.GroupCreationStrategy;

public class ConstructorStrategy extends GroupFactory {
    @Override
    Group createBy(GroupCreationStrategy base) {
        return new Group((baseGroup) base);
    }
}
