#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
	
	srand(time(NULL));
	int m[10][10];
	
	int l, c,soma = 0;
	float media = 0, multiplo = 0;
	
	for(l = 0; l < 10; l++ ){
		for(c = 0; c < 10; c++){
			m[l][c] = rand() % 100;
			printf("%2d ", m[l][c]);
			
			soma += m[l][c];
			
			if(m[l][c] % 5 == 0){
				multiplo++;
			}
		}
		printf("\n");
	}
	
	media = soma / 100;
	
	printf("Soma: %d \n", soma);
	printf("Media: %.2f\n", media);
	printf("Multiplos: %.2f", multiplo);
	
	return 0;
}
