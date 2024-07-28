package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.Parser;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.GroupCreationStrategy;

import java.util.Optional;

public abstract class GroupFactory {
    @SuppressWarnings("unused")
    abstract Group createBy(GroupCreationStrategy base);

    private static Group retrieve(GroupCreationStrategy o) {
        if (o instanceof Parser) {
            return ParseStrategy.INSTANCE().createBy(o);
        } else if (o instanceof baseGroup) {
            return ConstructorStrategy.INSTANCE().createBy(o);
        } else {
            return null;
        }
    }

    public static Group create(GroupCreationStrategy o) {
        return Optional.of(retrieve(o)).orElseThrow(() -> new RuntimeException("Error"));
    }

}
