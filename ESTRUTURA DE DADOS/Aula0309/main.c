#include <stdio.h>
#include <stdlib.h>

//Prototipo
int quadrado (int a);
void calcularDobro (int * n);

int main() {
	int n1, a;
	
	printf("Entre com um numero: ");
	scanf("%d", &n1);
	
	printf("Atribua um valor a A: ");
	scanf("%d", &a);
	
	calcularDobro(&a);
	
	printf("O seu quadrado vale: %d\n", quadrado(n1));
	printf("A vale: %d", a);
	
	return 0;
}

void calcularDobro (int * n){
	*n = *n * 2;
}

int quadrado (int a){
	a = a * a;
	return a;
}
