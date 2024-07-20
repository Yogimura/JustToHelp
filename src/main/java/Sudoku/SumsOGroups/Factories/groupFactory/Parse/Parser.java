package Sudoku.SumsOGroups.Factories.groupFactory.Parse;

import Sudoku.SumsOGroups.POJO.Group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    List<Character> values = new ArrayList<>(List.of('1','2','3','4','5','6','7','8','9'));
    public Group parse(String base) {
        if (!error(base)) {
            System.out.println("Formato incorrecto");
            return null;
        }
        List<String> parts = new ArrayList<>(List.of(base.split(":")));
        List<List<Integer>> options = new ArrayList<>();
        List<Integer> baseValues = Arrays.stream(parts.getFirst().split(",")).map(Integer::parseInt).toList();

        parts.removeFirst();
        for(String part: parts) {
            options.add(new ArrayList<>(List.of(part.split(","))).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }

        return new Group(baseValues.get(0), baseValues.get(1), options);
    }

    private Boolean error(String base) {
        char[] bases = base.toCharArray();

        for(int i = 0; i < bases.length; i++) {
            try {
                if(bases[i] == ':' || bases[i] == ',') {
                    if (!values.contains(bases[i-1]) || !values.contains(bases[i+1])) {
                        return false;
                    }
                }
            }catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }
}
