package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.GroupCreationStrategy;

public class ConstructorStrategy extends GroupFactory {
    private static ConstructorStrategy INSTANCE;

    @Override
    Group createBy(GroupCreationStrategy base) {
        return new Group((baseGroup) base);
    }

    public static ConstructorStrategy INSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ConstructorStrategy();
        }

        return INSTANCE;
    }
}
