#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void preencher(int *m, int n){
	int M[5][5];
	int l,c;
	for(l = 0; l < 5; l++){
		for(c = 0; c < 5; c++){
			M[l][c] = rand() % 100;
			
			printf("%2d ", M[l][c]);
			
		}
		printf("\n");
		
	}
}
void exibir(int m[5][5]){
	int M[5][5];
	int l,c;
	for(l = 0; l < 5; l++){
		for(c = 0; c < 5; c++){			
			printf("%2d ", M[l][c]);
		}
		printf("\n");
	}
}

int main() {
	
	
	
	
	exibir(&M[5][5]);
	
	
	
	return 0;
}
