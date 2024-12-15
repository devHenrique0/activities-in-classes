#include <stdio.h>
#include <stdlib.h>

struct ponto{
	int x, y;
};

//Protótipo
void atribui(struct ponto *p);

int main(int argc, char *argv[]) {
	struct ponto p1;
	
	
	atribui(&p1);
	
	printf("Valores de X e Y: \n");
	printf("X = %d e Y = %d", p1.x, p1.y);
	
	
	return 0;
}

void atribui(struct ponto *p){
	p->x = 10;
	p->y = 20;
}
