#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void preencherMatriz(int matriz[5][5]) {
    
    srand(time(NULL));
    int i, j; 
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            matriz[i][j] = rand() % 100; 
        }
    }
}


void mostrarMatriz(int matriz[5][5]) {
    int i, j; 
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            printf("%4d ", matriz[i][j]);
        }
        printf("\n");
    }
}

void copiarMatriz(int origem[5][5], int destino[5][5]) {
    int i, j; 
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            destino[i][j] = origem[i][j];
        }
    }
}

int main() {
    int M[5][5]; 
    int N[5][5]; 
    
    
    preencherMatriz(M);
    
    
    printf("Matriz M:\n");
    mostrarMatriz(M);
    

    copiarMatriz(M, N);
    
    
    printf("\nMatriz N (apos copiar M):\n");
    mostrarMatriz(N);
    
    return 0;
}

