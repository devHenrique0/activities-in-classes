#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void somar(int num1, int num2, int * n);

int main() {
	int num1, num2, numR;
	
	printf("Digite o valor do primeiro numero: ");
	scanf("%d", &num1);
	
	printf("Digite o valor do segundo numero: ");
	scanf("%d", &num2);
	
	somar(num1,num2,&numR); 
	
	printf("O valor da sua soma e: %d", numR);
	
	return 0;
}

void somar(int num1, int num2, int * n){
	*n = num1 + num2;
}
