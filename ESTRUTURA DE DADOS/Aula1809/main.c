#include <stdio.h>
#include <stdlib.h>

struct ponto{
	int x, y;
};


int main(int argc, char *argv[]) {

	int vet[5] = {1,2,3,4,5};
	int *p, *p1, x = 10, *n;
	int c = 10, d = 20;
	float y = 20.0;
	p = &x;
	printf("Conteudo apontando por p: %d \n", *p); 
	
	p1 = p;
	printf("Conteudo apontado por p1: %d \n", *p1);
	
	p = &y;
	printf("Conteudo apontado por p: %d \n", *p);
	printf("Conteudo apontado por p: %f \n", *p);	
	printf("Conteudo apontado por p: %f \n", *((float*)p));
	
// ----------------------------------------------------------------
//	p = &c;
//	p1 = &d;
//	
//	*p1 = *p;
//	
//	
//	printf("Conteudo apontado por p1: %d \n", d);
// -----------------------------------------------------------------
	
// -----------------------------------------------------------------
//	p = &c;
//	(*p)++;
//	
//	printf("Valor de p: %d \n", *p);
//	printf("Valor de c: %d \n", c);
//	
//	*p = (*p) *10;
//	
//	printf("Valor de p: %d \n", *p);
//	printf("Valor de c: %d \n", c);
// -----------------------------------------------------------------

// -----------------------------------------------------------------
//	n = vet;
//	
//	printf("Terceiro elemento: %d ou %d", n[2], *(n+2));
// -----------------------------------------------------------------

	struct ponto q;
	struct ponto *p;
	
	p= &q;
	
	(*p).x = 10;
	p->y = 20;
	
	return 0;
}



