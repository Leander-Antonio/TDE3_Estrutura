public class MergeSort {
    private static long trocas;
    private static long iteracoes;

    public static Main.Resultado sort(int[] arr) {
        trocas = 0;
        iteracoes = 0;
        mergeSort(arr, 0, arr.length - 1);
        return new Main.Resultado(trocas, iteracoes);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            iteracoes++;
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        } else {
            iteracoes++;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
            trocas++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
            trocas++;
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            iteracoes++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                trocas++;
            } else {
                arr[k] = R[j];
                j++;
                trocas++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            trocas++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            trocas++;
        }
    }
}
