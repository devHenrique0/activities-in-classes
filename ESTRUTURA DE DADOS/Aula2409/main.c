#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) {
	int x = 10;
	int *p1 = &x;
	int **p2 = &p1;
	
	//Endereço em p2
	printf("Endereco em p2: %p\n", p2);
	//Conteudo do Endereco
	printf("Conteudo em *p2: %p\n", *p2);
	//Conteudo do endereco do endereco
	printf("Conteudo em **p2: %d\n", **p2);
	return 0;
}
