public class Resultado {
    public String algoritmo;
    public int tamanho;
    public int seed;
    public long tempo;
    public int trocas;
    public int iteracoes;

    public Resultado(String algoritmo, int tamanho, int seed, long tempo, int trocas, int iteracoes) {
        this.algoritmo = algoritmo;
        this.tamanho = tamanho;
        this.seed = seed;
        this.tempo = tempo;
        this.trocas = trocas;
        this.iteracoes = iteracoes;
    }
}
