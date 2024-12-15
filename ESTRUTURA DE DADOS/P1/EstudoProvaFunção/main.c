#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
//Protótipo
void incrementa(int *n);
int matriz(int m[][1]);

int main(int argc, char *argv[]) {
//	int x = 5;
//	printf("O valor de X antes da funcao e: %d\n", x);
//	incrementa(&x);
//	printf("O valor de X depois da funcao e: %d\n", x);

int vet[1][1] = {5, 10, 15, 20};
	matriz(vet);
	return 0;
}

int matriz(int m[][1]){
	int i, j;
	for(i = 0; i <= 1; i++){
		for(j = 0; j <= 1; j++){
			printf("%d	", m[i][j]);
		}
		printf("\n");
	}
}

//void incrementa(int *n){
//	*n = *n + 1;
//	
//	printf("O valor de X na funcao e: %d\n", *n);
//}
