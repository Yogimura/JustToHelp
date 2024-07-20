package TestOSums;

import Sudoku.SumsOGroups.POJO.Group;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOfSumSize {
    private final List<Integer> values = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
    @Test
    @DisplayName("Test of two")
    public void twotest() {
        Group gp;

        for(int i = 3; i <= 17; i++) {
            gp = new Group(i, 2, List.of(values, values));
            gp.validate();
            switch (i) {
                case 3  -> {assertEquals(Set.of(1,2), gp.getValidValues());assertEquals(Set.of(3,4,5,6,7,8,9), gp.getInvalidValues());}
                case 4  -> {assertEquals(Set.of(1,3), gp.getValidValues());assertEquals(Set.of(2,4,5,6,7,8,9), gp.getInvalidValues());}
                case 5  -> {assertEquals(Set.of(1,2,3,4), gp.getValidValues());assertEquals(Set.of(5,6,7,8,9), gp.getInvalidValues());}
                case 6  -> {assertEquals(Set.of(1,2,4,5), gp.getValidValues());assertEquals(Set.of(3,6,7,8,9), gp.getInvalidValues());}
                case 7  -> {assertEquals(Set.of(1,2,3,4,5,6), gp.getValidValues());assertEquals(Set.of(7,8,9), gp.getInvalidValues());}
                case 8  -> {assertEquals(Set.of(1,2,3,5,6,7), gp.getValidValues());assertEquals(Set.of(4,8,9), gp.getInvalidValues());}
                case 9  -> {assertEquals(Set.of(1,2,3,4,5,6,7,8), gp.getValidValues());assertEquals(Set.of(9), gp.getInvalidValues());}
                case 10 -> {assertEquals(Set.of(1,2,3,4,6,7,8,9), gp.getValidValues());assertEquals(Set.of(5), gp.getInvalidValues());}
                case 11 -> {assertEquals(Set.of(2,3,4,5,6,7,8,9), gp.getValidValues());assertEquals(Set.of(1), gp.getInvalidValues());}
                case 12 -> {assertEquals(Set.of(3,4,5,7,8,9), gp.getValidValues());assertEquals(Set.of(1,2,6), gp.getInvalidValues());}
                case 13 -> {assertEquals(Set.of(4,5,6,7,8,9), gp.getValidValues());assertEquals(Set.of(1,2,3), gp.getInvalidValues());}
                case 14 -> {assertEquals(Set.of(5,6,8,9), gp.getValidValues());assertEquals(Set.of(1,2,3,4,7), gp.getInvalidValues());}
                case 15 -> {assertEquals(Set.of(6,7,8,9), gp.getValidValues());assertEquals(Set.of(1,2,3,4,5), gp.getInvalidValues());}
                case 16 -> {assertEquals(Set.of(7,9), gp.getValidValues());assertEquals(Set.of(1,2,3,4,5,6,8), gp.getInvalidValues());}
                case 17 -> {assertEquals(Set.of(8,9), gp.getValidValues());assertEquals(Set.of(1,2,3,4,5,6,7), gp.getInvalidValues());}
            }
        }

    }
}
