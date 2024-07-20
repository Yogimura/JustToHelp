package Sudoku.SumsOGroups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class size2strategy implements Iterate<Integer> {

    @Override
    public Set<Integer> iterateThrough(List<Integer> values, Integer finals) {
        Set<Integer> valid = new HashSet<>();
        for(Integer a: values) {
            for (Integer b: values) {
                if((a+b) == finals && !a.equals(b)) {
                    valid.add(a);
                    valid.add(b);
                }
            }
        }

        return valid;
    }
}
