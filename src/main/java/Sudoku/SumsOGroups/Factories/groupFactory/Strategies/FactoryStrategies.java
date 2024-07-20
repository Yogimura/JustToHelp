package Sudoku.SumsOGroups.Factories.groupFactory.Strategies;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;

public class FactoryStrategies {
    public Group create(Object o) {
        if(o.getClass() == String.class) {
            return new ParseStrategy().create((String)o);
        } else if(o.getClass() == baseGroup.class) {
            return new ConstructorStrategy().create((baseGroup) o);
        } else {
            return null;
        }
    }
}
