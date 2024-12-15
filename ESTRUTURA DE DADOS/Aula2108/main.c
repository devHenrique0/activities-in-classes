#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	int A[5][5];
	int B[5][5];
	int C[5][5];
	int menor, maior, contadorPar = 0, contadorImpar = 0;
	int l,c, somaA = 0, somaB = 0, mediaAB = 0;
	srand(time(NULL));

	
	for(l = 0; l < 5; l++){
		for(c = 0; c < 5; c++){
			A[l][c] = rand() % 100;
			
			printf("%2d ", A[l][c]);
			somaA += A[l][c];
		}
		printf("\n");
		
	}
	printf("\n");
	for(l = 0; l < 5; l++){
		
		for(c = 0; c < 5; c++){
			B[l][c] = rand() % 100;
			printf("%2d ", B[l][c]);
			
		}
		printf("\n");
	}
	printf("\n");
	
	menor = A[0][0] + B[0][0]; 
    maior = A[0][0] + B[0][0]; 
	
	for(l = 0; l < 5; l++){
		
		for(c = 0; c < 5; c++){
			mediaAB = (A[l][c] + B[l][c])/2;
			C[l][c] = mediaAB;
			printf("%2d ", C[l][c]);
			
			if(C[l][c] < menor){
				menor = C[l][c];
			}
			if(C[l][c] > maior){
				maior = C[l][c];
			}
			if(C[l][c] % 2 == 0){
				contadorPar++;
			}
			if(C[l][c] % 2 == 1){
				contadorImpar++;
			}
		}
		printf("\n");
	}
	printf("\n")
	
	for(l = 0; l < 5; l++){
		for(c = 0; c < 5; l++){
			printf("%d", C[l][c]);
		}
	}
	
	printf("Menor valor igual a: %d \n", menor);
	printf("Maior valor igual a: %d\n", maior);
	printf("O valor da quantidade de media pares sao: %d E a quantidade de media Impar e: %d", contadorPar, contadorImpar);
	
	return 0;
}
