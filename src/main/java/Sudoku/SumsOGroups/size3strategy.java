package Sudoku.SumsOGroups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class size3strategy implements Iterate<Integer> {

    @Override
    public Set<Integer> iterateThrough(List<Integer> values, Integer finals) {
        Set<Integer> valid = new HashSet<>();
        for(Integer a: values) {
            for (Integer b: values) {
                for (Integer c: values) {
                    if((a+b+c) == finals && !a.equals(b) && !b.equals(c) && !c.equals(a)) {
                        valid.add(a);
                        valid.add(b);
                        valid.add(c);
                    }
                }
            }
        }

        return valid;
    }
}
