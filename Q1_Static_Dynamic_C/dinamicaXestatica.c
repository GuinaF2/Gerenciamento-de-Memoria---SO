#include <stdio.h>
#include <stdlib.h>

int main(void) {
    // 1) Array estático (criado na stack)
    int estatico[5] = {1, 2, 3, 4, 5};

    // 2) Array dinâmico (criado na heap)
    int n = 10;
    int *dinamico = (int *) malloc(n * sizeof(int));

    // Verifica se a alocação deu certo
    if (dinamico == NULL) {
        printf("Insufficient Memory.\n");
        return 1;
    }

    // 3) Preenche o array dinâmico com valores de 10 a 19
    for (int i = 0; i < n; i++) {
        dinamico[i] = 10 + i;
    }

    // 4) Exibe valores e endereços do array estático
    printf("\n------------------Array Estático------------------\n");
    for (int i = 0; i < 5; i++) {
        printf("Estatico[%d] = %d\t(Memory Address: %p)\n", i, estatico[i], (void*)&estatico[i]);
    }

    // Exibe valores e endereços do array dinâmico
    printf("\n------------------Array Estatico------------------\n");
    for (int i = 0; i < n; i++) {
        printf("Dinamico[%d] = %d\t(Memory Address: %p)\n", i, dinamico[i], (void*)&dinamico[i]);
    }

    // 5) Calcula a diferença numérica entre os endereços base
    // (Usando conversão para int apenas para simplificar)
    int diferenca = (int)((long)&dinamico[0] - (long)&estatico[0]);

    printf("\nBase Address Estatico: %p\n", (void*)&estatico[0]);
    printf("Base Address Dinamico: %p\n", (void*)&dinamico[0]);
    printf("Difference between addresses (bytes): %d\n", diferenca);

    printf("\nObservacao: Valores muito diferentes indicam que as variaveis estao armazenadas em areas distintas da memoria.\n");

    // 6) Libera a memória dinâmica
    free(dinamico);
    dinamico = NULL;

    printf("\nMemoria dinamica liberada com sucesso.\n");

return 0;
}
