import java.util.Map;
import java.util.HashMap;

public class PrioridadeDasCores {

    public int[] getValoresCores() {

        //define a prioridade das cores
        Map<String, Integer> cor = new HashMap<>();

        cor.put("Vermelho", 5);
        cor.put("Laranja", 4);
        cor.put("Amarelo", 3);
        cor.put("Verde", 2);
        cor.put("Azul", 1);

        // String[] coresNaFila = cor.keySet().toArray(new String[0]);


        // fila de inserção aleatória das cores, para a ordenação
        String[] coresFila = {"Verde", "Vermelho", "Azul", "Amarelo", "Laranja"};


        //cria um vetor fora do "loop" para armazenar o valores das cores (int)
        int[] valorCoresFila = new int[coresFila.length];


        //le as cores que estão na fila e "transforma" elas em valores inteiros para serem comparados
        for (int i = 0; i < coresFila.length; i++) {

            // acessa a cor da fila e com a funcão "cor.get" pega o valor do map e salva na variável
            int valorCor = cor.get(coresFila[i]);

            // coloca a variável dentro do vetor
            valorCoresFila[i] = valorCor;


        }


        return valorCoresFila;
    }
}