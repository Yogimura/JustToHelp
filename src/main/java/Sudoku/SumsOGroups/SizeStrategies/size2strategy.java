package Sudoku.SumsOGroups.SizeStrategies;

import Sudoku.SumsOGroups.Types.Iterate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class size2strategy implements Iterate<Integer> {

    @Override
    public Set<Integer> iterateThrough(List<List<Integer>> values, Integer finals) {
        Set<Integer> valid = new HashSet<>();
        for (Integer a : values.get(0)) {
            for (Integer b : values.get(1)) {
                if ((a + b) == finals &&
                        !a.equals(b)) {

                    valid.add(a);
                    valid.add(b);
                }
            }
        }

        return valid;
    }
}
