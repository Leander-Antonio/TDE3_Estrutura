public class QuickSort {
    private static long trocas;
    private static long iteracoes;

    public static Main.Resultado sort(int[] arr) {
        trocas = 0;
        iteracoes = 0;
        quickSort(arr, 0, arr.length - 1);
        return new Main.Resultado(trocas, iteracoes);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            iteracoes++;
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        } else {
            iteracoes++;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            iteracoes++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            trocas++;
        }
    }
}
