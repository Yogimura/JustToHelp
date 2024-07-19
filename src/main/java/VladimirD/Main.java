package VladimirD;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        grupo ocho = new grupo(30, 4, valores);
        ocho.validar();
        System.out.println(ocho.getValores_validos());
        System.out.println(ocho.getValores_invalidos());
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
                if((a+b) == finals && a != b) {
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
                    if((a+b+c) == finals && a != b && b != c && c != a) {
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
                        if((a+b+c+d) == finals && a != b && b != c && c != d && d != a) {
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

class iterStrategyFactory<T> {
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

