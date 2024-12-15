#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int vetor[10], ref, countMenor = 0, countRef = 0;
    int vetor2[50], countPresenca = 0;

    // Lendo os 10 n�meros para o vetor
    printf("Digite 10 n�meros inteiros:\n");
    for (int i = 0; i < 10; i++) {
        scanf("%d", &vetor[i]);
    }

    // Lendo o valor de refer�ncia
    printf("Digite o valor de refer�ncia: ");
    scanf("%d", &ref);

    // (a) Imprimindo os n�meros maiores que o valor de refer�ncia
    printf("N�meros maiores que %d:\n", ref);
    for (int i = 0; i < 10; i++) {
        if (vetor[i] > ref) {
            printf("%d ", vetor[i]);
        }
    }

    // (b) Contando os n�meros menores que o valor de refer�ncia
    for (int i = 0; i < 10; i++) {
        if (vetor[i] < ref) {
            countMenor++;
        }
    }
    printf("\nQuantidade de n�meros menores que %d: %d\n", ref, countMenor);

    // (c) Contando quantas vezes o valor de refer�ncia aparece no vetor
    for (int i = 0; i < 10; i++) {
        if (vetor[i] == ref) {
            countRef++;
        }
    }
    printf("O valor %d aparece %d vezes no vetor.\n", ref, countRef);

    // (d) Gerando o segundo vetor e contabilizando a presen�a dos n�meros
    srand(time(NULL)); // Gerando n�meros aleat�rios
    for (int i = 0; i < 50; i++) {
        vetor2[i] = rand() % 100; // N�meros entre 0 e 99
    }

    // (d.i) Contabilizando quantas vezes cada n�mero do vetor 1 aparece no vetor 2
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 50; j++) {
            if (vetor[i] == vetor2[j]) {
                countPresenca++;
            }
        }
    }

    // (d.ii) Calculando o percentual de presen�a
    float percentual = (float)countPresenca / 50 * 100;
    printf("Percentual de n�meros do primeiro vetor presentes no segundo: %.2f%%\n", percentual);

    return 0;
}

