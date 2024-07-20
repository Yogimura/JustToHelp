package Sudoku.SumsOGroups.SizeStrategies;

import Sudoku.SumsOGroups.Types.Iterate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class size4strategy implements Iterate<Integer> {

    @Override
    public Set<Integer> iterateThrough(List<List<Integer>> values, Integer finals) {
        Set<Integer> valid = new HashSet<>();
        for (Integer a : values.get(0)) {
            for (Integer b : values.get(1)) {
                for (Integer c : values.get(2)) {
                    for (Integer d : values.get(3)) {
                        if ((a + b + c + d) == finals &&
                                !a.equals(b) && !b.equals(c) &&
                                !c.equals(d) && !d.equals(a) &&
                                !a.equals(c) && !b.equals(d)) {
                            valid.add(a);
                            valid.add(b);
                            valid.add(c);
                            valid.add(d);
                        }
                    }
                }
            }
        }

        return valid;
    }
}
