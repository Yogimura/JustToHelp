package Sudoku;

import Sudoku.SumsOGroups.Group;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> values = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
    private static final String[] numberSpell = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        getGroups(2);
        System.out.println();
        getGroups(3);
        System.out.println();
        getGroups(4);
    }

    private static void getGroups(Integer size) {
        System.out.println("Groups of " + numberSpell[size-1]);
        for(int i = 1; i <= 45; i++) {
            Group gp = new Group(i, size, values);
            gp.validate();
            if(gp.getValidValues().isEmpty()) {
                continue;
            }
            System.out.println(gp);
        }
    }
}

