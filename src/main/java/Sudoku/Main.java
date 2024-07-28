package Sudoku;

import Sudoku.SumsOGroups.Factories.groupFactory.Parse.Parser;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.baseGroup;
import Sudoku.SumsOGroups.Factories.groupFactory.Strategies.GroupFactory;
import Sudoku.SumsOGroups.POJO.Group;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Integer> values = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9)){
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for(Integer e: this) {
                result.append(e).append(",");
            }
            return result.substring(0, result.length()-1);
        }
    };
    private static final String[] numberSpell = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) {
        getGroups(2);
        System.out.println();
        getGroups(3);
        System.out.println();
        getGroups(4);
        System.out.println();
        getGroups(5);
        System.out.println("\n");
        Group group = GroupFactory.create(new Parser("4,2:"+values+":"+values));
        group.validate();
        System.out.println(group.getValidValues());
    }

    private static void getGroups(Integer size) {
        System.out.println("Groups of " + numberSpell[size-1]);
        List<List<Integer>> options = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            options.add(values);
        }
        for(int i = 1; i <= 45; i++) {
            Group gp = GroupFactory.create(new baseGroup(i, size, options));
            gp.validate();
            if(gp.getValidValues().isEmpty()) {
                continue;
            }
            System.out.println(gp);
        }
    }
}

