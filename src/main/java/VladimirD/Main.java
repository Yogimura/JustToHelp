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
            grupo gp = new grupo(i, size, values);
            gp.validar();
            if(gp.getValores_validos().isEmpty()) {
                continue;
            }
            System.out.println(gp);
        }
    }
}

@Getter @Setter
class grupo {
    private int valor_final;
    private int size;
    private Set<Integer> valores_validos;
    private Set<Integer> valores_invalidos;
    private List<Integer> valores;

    public grupo(int valor_final, int size, List<Integer> valores) {
        this.valor_final = valor_final;
        this.size = size;
        this.valores = valores;
    }

    public void validar() {
        valores_validos = StrategyManager.runTh(this);
        valores_invalidos = getValoresInvalidos();
    }

    private Set<Integer> getValoresInvalidos() {
        Set<Integer> invals = new HashSet<>();
        for(Integer val: valores) {
            if (!valores_validos.contains(val)) {
                invals.add(val);
            }
        }

        return invals;
    }

    @Override
    public String toString() {
        return "grupo{" +
                "valores_validos=" + getValores_validos() +
                ", valores_invalidos=" + getValores_invalidos() +
                ", valor_final=" + getValor_final() +
                '}';
    }
}

interface sizeIterate<T> {
    Set<T> iterateTh(List<T> t, Integer i);
}

class StrategyManager {
    public static Set<Integer> runTh(grupo gp) {
        sizeIterate<Integer> go = iterStrategyFactory.create(gp.getSize());
        assert go != null;
        return go.iterateTh(gp.getValores(), gp.getValor_final());
    }
}

class size2strategy implements sizeIterate<Integer>{

    @Override
    public Set<Integer> iterateTh(List<Integer> values, Integer finals) {
        Set<Integer> valids = new HashSet<>();
        for(Integer a: values) {
            for (Integer b: values) {
                if((a+b) == finals && !a.equals(b)) {
                    valids.add(a);
                    valids.add(b);
                }
            }
        }

        return valids;
    }
}

class size3strategy implements sizeIterate<Integer> {

    @Override
    public Set<Integer> iterateTh(List<Integer> values, Integer finals) {
        Set<Integer> valids = new HashSet<>();
        for(Integer a: values) {
            for (Integer b: values) {
                for (Integer c: values) {
                    if((a+b+c) == finals && !a.equals(b) && !b.equals(c) && !c.equals(a)) {
                        valids.add(a);
                        valids.add(b);
                        valids.add(c);
                    }
                }
            }
        }

        return valids;
    }
}

class size4strategy implements sizeIterate<Integer> {

    @Override
    public Set<Integer> iterateTh(List<Integer> values, Integer finals) {
        Set<Integer> valids = new HashSet<>();
        for (Integer a: values) {
            for (Integer b: values) {
                for (Integer c: values) {
                    for (Integer d: values) {
                        if((a+b+c+d) == finals && !a.equals(b) && !b.equals(c) && !c.equals(d) && !d.equals(a) && !a.equals(c) && !b.equals(d)) {
                            valids.add(a);
                            valids.add(b);
                            valids.add(c);
                            valids.add(d);
                        }
                    }
                }
            }
        }

        return valids;
    }
}

class iterStrategyFactory {
    public static sizeIterate<Integer> create(int size) {
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

