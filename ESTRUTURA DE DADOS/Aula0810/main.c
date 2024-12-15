#include <stdio.h>
#include <stdlib.h>

struct ponto{
	int x,y;
};

int main(int argc, char *argv[]) {
	
//	printf("char: %d\n", sizeof(char));
//	printf("int: %d\n", sizeof(int));
//	printf("float: %d\n", sizeof(float));
//	printf("ponto: %d\n", sizeof(struct ponto));

//int *p;
//p = (int *) malloc(5*sizeof(int));
//if(p == NULL){
//	printf("Erro: Memoria Insuficiente \n");
//	system("pause");
//	exit(1);
//}
//int i;
//for(i=0; i<5; i++){
//	printf("Indique o valor da posicao %d: ", i);
//	scanf("%d", &p[i]);
//}
//
//int *p1;
//p = (int *) calloc(5,sizeof(int));
//if(p1 == NULL){
//	printf("Erro: Memoria Insuficiente \n");
//}

int i;
int *p = malloc(5*sizeof(int));
for(i = 0; i < 5; i++){
	p[i] = i + 1;
}
for(i = 0; i < 5; i++){
	printf("%d\n", p[i]);
}
printf("\n");

p = realloc(p,3*sizeof(int));
for(i = 0; i < 3; i++){
	printf("%d\n", p[i]);
}
printf("\n");

p = realloc(p,10*sizeof(int));
for(i = 0; i < 10; i++){
	printf("%d\n", p[i]);
}
printf("\n");

free(p);

	return 0;
}




