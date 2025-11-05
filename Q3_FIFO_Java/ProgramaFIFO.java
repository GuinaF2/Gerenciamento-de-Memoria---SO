package FIFO;

import java.util.ArrayList; // usado para armazenar as páginas na memória (estrutura de lista dinâmica)
import java.util.Scanner; // usado para ler as entradas digitadas pelo usuário

public class ProgramaFIFO {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  // cria o leitor de entrada do usuário
        ArrayList<Integer> memoria = new ArrayList<>();  // lista que simula os quadros de memória
        int numeroFrames = 0;   // quantidade de frames disponíveis na memória
        int totalFaltas = 0;    // contador de faltas de página (page faults)

        System.out.println(" Substituição de Página FIFO \n");

        // Entrada e validação do número de frames
        while (true) {
            try {
                System.out.print("Digite o número de frames disponíveis (máximo 5 caracteres): ");
                String entrada = input.nextLine(); // lê o texto digitado

                // Verifica se o texto tem mais de 5 caracteres
                if (entrada.length() > 5) {
                    System.out.println("Erro: número de caracteres excedido, máximo 5 caracteres. Tente novamente.\n");
                    continue;
                }

                // Converte o valor digitado para inteiro
                numeroFrames = Integer.parseInt(entrada);

                // Garante que o número seja maior que zero
                if (numeroFrames <= 0) {
                    System.out.println("Erro: o número deve ser maior que zero.\n");
                    continue;
                }

                // Se passou por todas as verificações, sai do loop
                break;

            } catch (NumberFormatException e) {
                // Mensagem exibida quando o usuário digita algo que não é número
                System.out.println("Erro: Número inválido.\n");
            }
        }

        // Entrada da sequência de páginas
        System.out.println("\nDigite as referências de página (separe os números por espaço, ex: 7 0 1 2 0 3):");
        System.out.print("→ ");
        String[] paginasTexto = input.nextLine().trim().split("\\s+"); // separa os números digitados pelos espaços

        // Validação do tamanho de cada número digitado
        for (String ref : paginasTexto) {
            if (ref.length() > 5) {
                System.out.println("Erro: número de caracteres excedido, máximo 5 caracteres. Tente novamente.");
                input.close();
                return;
            }
        }

        // Conversão das páginas digitadas (texto) para números inteiros
        int[] paginas = new int[paginasTexto.length];
        try {
            for (int i = 0; i < paginasTexto.length; i++) {
                paginas[i] = Integer.parseInt(paginasTexto[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: sequência de páginas inválida. Use apenas números.");
            input.close();
            return;
        }

        // Início da simulação FIFO 
        System.out.println("\n===== Iniciando Simulação FIFO =====\n");
        // Cabeçalho da tabela
        System.out.printf("%-12s | %-25s | %-25s | %-15s\n", "Referência", "Frames", "Resultado", "Total Faltas");
        System.out.println("-----------------------------------------------------------------------------------------");

        // Percorre cada página referenciada
        for (int pagina : paginas) {
            String resultado; // armazena o que aconteceu: acerto ou falta

            // Se a página já estiver na memória → acerto
            if (memoria.contains(pagina)) {
                resultado = "Acerto (Page Hit)";
            } else {
                // Se não estiver → falta de página
                totalFaltas++;

                // Se ainda houver espaço na memória, adiciona a nova página
                if (memoria.size() < numeroFrames) {
                    memoria.add(pagina);
                    resultado = "Falta (Page Fault)";
                } else {
                    // Se estiver cheia, remove a mais antiga (primeira da fila)
                    int removida = memoria.remove(0);
                    memoria.add(pagina);
                    resultado = "Falta (substituiu " + removida + ")";
                }
            }

            // Exibe o estado da memória e o resultado atual
            System.out.printf("%-12d | %-25s | %-25s | %-15d\n",
                    pagina, memoria.toString(), resultado, totalFaltas);
        }

        // Exibe estatísticas finais
        double taxaFaltas = (double) totalFaltas / paginas.length * 100; // cálculo da taxa de faltas

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Total de referências: " + paginas.length);
        System.out.println("Total de faltas de página: " + totalFaltas);
        System.out.printf("Taxa de faltas de página: %.2f%%\n", taxaFaltas);

        // Liberação de memória (simulação do 'free')
        System.out.println("\nLiberando memória da fila FIFO...");
        memoria.clear();   // apaga todos os dados da lista
        memoria = null;    // remove a referência
        System.gc();       // pede ao Garbage Collector para liberar o espaço
        System.out.println("Memória liberada com sucesso ");

        // Fecha o Scanner para evitar vazamento de recurso
        input.close();
    }
}
