package br.upa;

import java.util.Arrays;
import java.util.List;

public class MergeSort {

    // recebe a lista na ordem de chegada e devolve uma nova lista ordenada
    public static List<Paciente> ordenar(List<Paciente> pacientes) {
        Paciente[] p1 = pacientes.toArray(new Paciente[0]);
        // array auxiliar do mesmo tamanho para as trocas de posicao
        Paciente[] p2 = new Paciente[p1.length];

        mergeSort(p1, p2, 0, p1.length - 1);
        return Arrays.asList(p1);
    }

    private static void mergeSort(Paciente[] p1, Paciente[] p2, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(p1, p2, inicio, meio);
            mergeSort(p1, p2, meio + 1, fim);
            intercalar(p1, p2, inicio, meio, fim);
        }
    }

    private static void intercalar(Paciente[] p1, Paciente[] p2, int inicio, int meio, int fim) {
        for (int k = inicio; k <= fim; k++) {
            p2[k] = p1[k];
        }

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            if (i > meio) p1[k] = p2[j++];
            else if (j > fim) p1[k] = p2[i++];
            else if (vemAntes(p2[i], p2[j])) p1[k] = p2[i++];
            else p1[k] = p2[j++];
        }
    }

    // true se o paciente "a" deve ser atendido antes (ou junto) do paciente "b"
    // 1o criterio: cor (maior prioridade primeiro)
    // 2o criterio: idade (mais velho primeiro)
    // empate total: mantem a ordem de chegada
    private static boolean vemAntes(Paciente a, Paciente b) {
        int prioridadeA = PrioridadeDasCores.getPrioridade(a.getCor());
        int prioridadeB = PrioridadeDasCores.getPrioridade(b.getCor());

        if (prioridadeA != prioridadeB) {
            return prioridadeA > prioridadeB;
        }
        return a.getIdade() >= b.getIdade();
    }
}
