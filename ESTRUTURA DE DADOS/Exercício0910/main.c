#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) {
//	int i;
//	int *p;
//	p = (int *) malloc(1*sizeof(int));
//	
//	for(i = 0; i < 1; i++){
//		printf("Indique o valor da posicao %d", i);
//		scanf("%d", &p[i]);
//		
//		if(p[i] == -1){
//			exit(1);
//		}else{
//			p = realloc(p,i++*sizeof(int));
//		}
//	}


	int numero = 0;
	
	int *numeros;
	int cont = 0;
	
	while(numero != -1){
		printf("Digite um numero:");
		scanf("%d", &numero);
		
		cont++;
		
		numeros = (int*) realloc(numeros, cont * sizeof(int));
		
		numeros[cont - 1] = numero;
	}

	return 0;
}
