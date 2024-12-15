#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	int A[2][2], B[2][2], C[2][2];
	int i, j, soma = 0;
	
	for(i = 0; i < 2; i++){
		for(j = 0; j < 2; j++){
			printf("Valor da Matriz A[%d][%d]", i, j);
			scanf("%d", &A[i][j]);
		}
	}
	
	for(i = 0; i < 2; i++){
		for(j = 0; j < 2; j++){
			printf("Valor da Matriz B[%d][%d]", i, j);
			scanf("%d", &B[i][j]);
		}
	}
	
	for(i = 0; i < 2; i++){
		for(j = 0; j < 2; j++){
			C[i][j] = A[i][j] + B[i][j];
		}
	}
	
	for(i = 0; i < 2; i++){
		for(j = 0; j < 2; j++){
			printf("%d	", C[i][j]);
		}
		printf("\n");
	}
	
//	for(i = 0; i < 5; i++){
//		for(j = 0; j < 5; j++){
//			printf("Preencha a matriz mat[%d][%d]: ", i,j);
//			scanf("%d", &mat[i][j]);
//		}
//	}
//	
//	for(i = 0; i < 5; i++){
//		for(j = 0; j < 5; j++){
//			printf("%d	", mat[i][j]);
//		}
//		printf("\n");
//	}
//	
//	for(i = 0; i < 5; i++){
//		for(j = 0; j < 5; j++){
//			soma = soma + mat[i][j];
//		}
//	}
//	
//	printf("%d", soma);
	
	return 0;
}
