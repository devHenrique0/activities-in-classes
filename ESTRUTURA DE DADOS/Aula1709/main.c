#include <stdio.h>
#include <stdlib.h>


int main(int argc, char *argv[]) {
	
	int c = 10;
	
	int *p;
	
	p = &c;
	printf("Conteudo apontado por p: %d \n", *p);
	//Atribui um novo valor � posi��o de mem�ria
	*p = 12;
	
	printf("Conteudo apontando por p: %d \n", *p);
	printf("Conteudo de count: %d \n", c);//12

	return 0;
}

