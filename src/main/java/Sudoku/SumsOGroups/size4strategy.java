package Sudoku.SumsOGroups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class size4strategy implements Iterate<Integer> {

    @Override
    public Set<Integer> iterateThrough(List<Integer> values, Integer finals) {
        Set<Integer> valid = new HashSet<>();
        for (Integer a: values) {
            for (Integer b: values) {
                for (Integer c: values) {
                    for (Integer d: values) {
                        if((a+b+c+d) == finals && !a.equals(b) && !b.equals(c) && !c.equals(d) && !d.equals(a) && !a.equals(c) && !b.equals(d)) {
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
