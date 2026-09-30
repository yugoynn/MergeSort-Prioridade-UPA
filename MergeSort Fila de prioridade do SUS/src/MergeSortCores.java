import java.util.Arrays;

public class MergeSortCores {

    public static void main(String[] args) {


        //chama e classe das cores
        PrioridadeDasCores cores = new PrioridadeDasCores();

        //e pega a variável dos valores das cores
        int[] p1 = cores.getValoresCores();
        int[] p2 = new int[p1.length];
        //define um array do tamanho do array principal como auxiliar nas trocar de posição

        // p1, p2, inicio e fim
        mergeSort(p1, p2, 0, p1.length - 1);
        System.out.println(Arrays.toString(p1));
    }


    //MERGE SORT

    private static void mergeSort(int[] p1, int[] p2, int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(p1, p2, inicio, meio);
            mergeSort(p1, p2, meio+1, fim);
            intercalar(p1, p2, inicio, meio, fim);
        }

    }

    private static void intercalar(int[] p1, int[] p2, int inicio, int meio, int fim){
        for(int k = inicio; k <= fim; k++) {
            p2[k] = p1[k];
        }

        int i = inicio;
        int j = meio + 1;

        for( int k = inicio; k <= fim; k++){
            if (i > meio) p1[k] = p2[j++];
            else if (j > fim) p1[k] = p2[i++];
            else if (p2[i] < p2[j]) p1[k] = p2[i++];
            else p1[k] = p2[j++];
        }


    }


}
