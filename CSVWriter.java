import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {

    public static void salvarResultadosCSV(String nomeArquivo, List<Resultado> resultados) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeArquivo))) {
            pw.println("Algoritmo,Tamanho,Seed,Tempo(ms),Trocas,Iteracoes");
            for (Resultado r : resultados) {
                pw.printf("%s,%d,%d,%d,%d,%d\n",
                        r.algoritmo,
                        r.tamanho,
                        r.seed,
                        r.tempo,
                        r.trocas,
                        r.iteracoes);
            }
            System.out.println("Arquivo CSV gerado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar CSV: " + e.getMessage());
        }
    }
}
