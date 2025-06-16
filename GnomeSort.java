public class GnomeSort {
    public static Main.Resultado sort(int[] arr) {
        long trocas = 0;
        long iteracoes = 0;
        int index = 0;

        while (index < arr.length) {
            iteracoes++;
            if (index == 0) {
                index++;
            } else if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                trocas++;
                index--;
            }
        }

        return new Main.Resultado(trocas, iteracoes);
    }
}
