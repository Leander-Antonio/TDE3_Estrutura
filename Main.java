import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static class Resultado {
        public long trocas;
        public long iteracoes;

        public Resultado(long trocas, long iteracoes) {
            this.trocas = trocas;
            this.iteracoes = iteracoes;
        }
    }

    public static void main(String[] args) {
        int[] tamanhos = {1000, 10000, 100000, 500000, 1_000_000};
        int[] seeds = {42, 99, 123, 2024, 777};

        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.write("Algoritmo,Tamanho,Seed,Tempo(ms),Trocas,Iteracoes\n");

            for (int tamanho : tamanhos) {
                for (int seed : seeds) {
                    int[] original = gerarArrayAleatorio(tamanho, seed);

                    // InsertSort
                    int[] arrInsert = original.clone();
                    long start = System.currentTimeMillis();
                    Resultado resInsert = InsertSort.sort(arrInsert);
                    long tempo = System.currentTimeMillis() - start;
                    writer.write(String.format("InsertSort,%d,%d,%d,%d,%d\n",
                            tamanho, seed, tempo, resInsert.trocas, resInsert.iteracoes));

                    // QuickSort
                    int[] arrQuick = original.clone();
                    start = System.currentTimeMillis();
                    Resultado resQuick = QuickSort.sort(arrQuick);
                    tempo = System.currentTimeMillis() - start;
                    writer.write(String.format("QuickSort,%d,%d,%d,%d,%d\n",
                            tamanho, seed, tempo, resQuick.trocas, resQuick.iteracoes));

                    // MergeSort
                    int[] arrMerge = original.clone();
                    start = System.currentTimeMillis();
                    Resultado resMerge = MergeSort.sort(arrMerge);
                    tempo = System.currentTimeMillis() - start;
                    writer.write(String.format("MergeSort,%d,%d,%d,%d,%d\n",
                            tamanho, seed, tempo, resMerge.trocas, resMerge.iteracoes));

                    // GnomeSort
                    int[] arrGnome = original.clone();
                    start = System.currentTimeMillis();
                    Resultado resGnome = GnomeSort.sort(arrGnome);
                    tempo = System.currentTimeMillis() - start;
                    writer.write(String.format("GnomeSort,%d,%d,%d,%d,%d\n",
                            tamanho, seed, tempo, resGnome.trocas, resGnome.iteracoes));

                    writer.flush();
                }
            }

            System.out.println("Arquivo resultados.csv gerado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo resultados.csv");
            e.printStackTrace();
        }
    }

    private static int[] gerarArrayAleatorio(int tamanho, int seed) {
        Random rand = new Random(seed);
        int[] arr = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
}
