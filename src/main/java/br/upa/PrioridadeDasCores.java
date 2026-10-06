package br.upa;

import java.util.HashMap;
import java.util.Map;

public class PrioridadeDasCores {

    // define a prioridade das cores (maior numero = atendido antes)
    private static final Map<String, Integer> CORES = new HashMap<>();

    static {
        CORES.put("Vermelho", 5);
        CORES.put("Laranja", 4);
        CORES.put("Amarelo", 3);
        CORES.put("Verde", 2);
        CORES.put("Azul", 1);
    }

    public static boolean corValida(String cor) {
        return CORES.containsKey(cor);
    }

    public static int getPrioridade(String cor) {
        return CORES.get(cor);
    }
}
