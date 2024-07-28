package Sudoku.SumsOGroups.POJO;

import Sudoku.SumsOGroups.Controllers.StrategyManager;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class Group {
    private int fullValue;
    private int size;
    private Set<Integer> validValues;
    private Set<Integer> invalidValues;
    private List<List<Integer>> optionValues;

    public Group(baseGroup base) {
        this.fullValue = base.fullValue();
        this.size = base.size();
        this.optionValues = base.options();
    }

    public Group(int fullValue, int size, List<List<Integer>> optionValues) {
        this.fullValue = fullValue;
        this.size = size;
        this.optionValues = optionValues;
    }

    public void validate() {
        validValues = StrategyManager.run(this);
        invalidValues = extractInvalidValues();
    }

    private Set<Integer> extractInvalidValues() {
        Set<Integer> invalids = new HashSet<>();
        Set<Integer> values = new HashSet<>();
        for(List<Integer> base: optionValues) {
            values.addAll(base);
        }
        for(Integer val: values) {
            if (!validValues.contains(val)) {
                invalids.add(val);
            }
        }

        return invalids;
    }

    @Override
    public String toString() {
        return "Group{" +
                "validValues=" + getValidValues() +
                ", invalidValues=" + getInvalidValues() +
                ", fullValue=" + getFullValue() +
                '}';
    }
}
