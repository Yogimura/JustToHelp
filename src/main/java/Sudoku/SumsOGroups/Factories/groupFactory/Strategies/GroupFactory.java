package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.Parser;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Types.GroupCreationStrategy;

import java.util.Objects;

public abstract class GroupFactory{
    abstract Group createBy(GroupCreationStrategy base);

    private static Group retrieve(GroupCreationStrategy o) {
        if(o.getClass().equals(Parser.class)) {
            return new ParseStrategy().createBy(o);
        } else if(o.getClass().equals(baseGroup.class)) {
            return new ConstructorStrategy().createBy(o);
        }else {
            return null;
        }
    }

    public static Group create(GroupCreationStrategy o) {
        return Objects.requireNonNull(retrieve(o));
    }

}
