package VladimirD;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@Getter @Setter
class Group {
    private int fullValue;
    private int size;
    private Set<Integer> validValues;
    private Set<Integer> invalidValues;
    private List<Integer> optionValues;

    public Group(int fullValue, int size, List<Integer> optionValues) {
        this.fullValue = fullValue;
        this.size = size;
        this.optionValues = optionValues;
    }

    public void validate() {
        validValues = StrategyManager.run(this);
        invalidValues = extractInvalidValues();
    }

    private Set<Integer> extractInvalidValues() {
        Set<Integer> invalids = new HashSet<>();
        for(Integer val: optionValues) {
            if (!validValues.contains(val)) {
                invalids.add(val);
            }
        }

        return invalids;
    }

    @Override
    public String toString() {
        return "Group{" +
                "validValues=" + getValidValues() +
                ", invalidValues=" + getInvalidValues() +
                ", fullValue=" + getFullValue() +
                '}';
    }
}

interface Iterate<T> {
    Set<T> iterateThrough(List<T> t, Integer i);
}

class StrategyManager {
    public static Set<Integer> run(Group gp) {
        Iterate<Integer> iterator = iterateStrategyFactory.create(gp.getSize());
        assert iterator != null;
        return iterator.iterateThrough(gp.getOptionValues(), gp.getFullValue());
    }
}

class size2strategy implements Iterate<Integer> {

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

class size3strategy implements Iterate<Integer> {

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

class size4strategy implements Iterate<Integer> {

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

class iterateStrategyFactory {
    public static Iterate<Integer> create(int size) {
        switch (size) {
            case 2 -> {
                return new size2strategy();
            }

            case 3 -> {
                return new size3strategy();
            }

            case 4 -> {
                return new size4strategy();
            }

            default -> {
                return null;
            }
        }
    }
}

