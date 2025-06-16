public class InsertSort {
    public static Main.Resultado sort(int[] arr) {
        long trocas = 0;
        long iteracoes = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            iteracoes++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                trocas++;
                iteracoes++;
            }
            arr[j + 1] = key;
            iteracoes++;
        }

        return new Main.Resultado(trocas, iteracoes);
    }
}
