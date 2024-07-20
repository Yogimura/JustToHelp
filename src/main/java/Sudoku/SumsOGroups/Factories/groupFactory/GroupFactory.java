package Sudoku.SumsOGroups.Factories.groupFactory;

import Sudoku.SumsOGroups.Factories.groupFactory.Strategies.FactoryStrategies;
import Sudoku.SumsOGroups.POJO.Group;

public class GroupFactory {
    public Group run(Object o) {
        FactoryStrategies factoryStrategies = new FactoryStrategies();
        return factoryStrategies.create(o);
    }
}
