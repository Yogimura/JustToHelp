package Sudoku;

import Sudoku.SumsOGroups.Factories.groupFactory.GroupFactory;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.POJO.Group;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> values = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
    private static final String[] numberSpell = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        GroupFactory groupFactory = new GroupFactory();
        String parseCode = "4,2:1,2,3,4,5,6,7,8,9:1,2,3,4,5,6,7,8,9";
        Group gp2 = groupFactory.run(parseCode);
        gp2.validate();
        System.out.println(gp2);

        Group gp3 = groupFactory.run(new baseGroup(6,3, List.of(values, values, values)));
        gp3.validate();
        System.out.println(gp3);
    }

    private static void getGroups(Integer size) {
        System.out.println("Groups of " + numberSpell[size-1]);
        List<List<Integer>> options = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            options.add(values);
        }
        for(int i = 1; i <= 45; i++) {
            Group gp = new Group(i, size, options);
            gp.validate();
            if(gp.getValidValues().isEmpty()) {
                continue;
            }
            System.out.println(gp);
        }
    }
}

