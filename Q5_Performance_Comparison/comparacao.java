public class Main {
    // Número de repetições para tirar média
    private static final int REPETICOES = 10;

    // Quantidade de operações feitas em cada teste
    private static final int OPERACOES = 1_000_000;

    public static void main(String[] args) {

        long tempoMedioStack = testarStack();
        long tempoMedioHeap = testarHeap();

        System.out.println("======= RESULTADOS =======");
        System.out.println("Média - Alocação na PILHA: " + tempoMedioStack + " ns");
        System.out.println("Média - Alocação no HEAP:  " + tempoMedioHeap + " ns");

        double diferenca = ((double) tempoMedioHeap / tempoMedioStack - 1) * 100;
        System.out.printf("Diferença percentual (Heap vs Stack): %.2f%%\n", diferenca);
    }

    // Teste de alocação na pilha
    private static long testarStack() {
        long soma = 0;

        for (int r = 0; r < REPETICOES; r++) {

            long inicio = System.nanoTime();

            for (int i = 0; i < OPERACOES; i++) {
                int x = i; // variável local, vive na stack, criação e destruição são baratas
            }

            long fim = System.nanoTime();
            soma += (fim - inicio);
        }

        return soma / REPETICOES;
    }

    // Teste de alocação no heap
    private static long testarHeap() {
        long soma = 0;

        for (int r = 0; r < REPETICOES; r++) {

            long inicio = System.nanoTime();

            for (int i = 0; i < OPERACOES; i++) {
                new ObjetoExemplo(i);
                // criação no heap; GC decide quando destruir mais tarde
            }

            long fim = System.nanoTime();
            soma += (fim - inicio);

            System.gc(); // pequena ajuda para minimizar interferência
        }

        return soma / REPETICOES;
    }
    // Classe simples para instanciar no heap
    static class ObjetoExemplo {
        int valor;

        public ObjetoExemplo(int v) {
            this.valor = v;
        }
    }
}
