#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
struct endereco {
	
};

struct aluno {
	int codigo;
	float n1, n2, n3, media;	
	};
	
int main(int argc, char *argv[]) {
	struct aluno listaAlunos[20];
	int i;
	printf("COD\t n1 \t n2 \t n3 \t MEDIA\n");
	for(i = 0; i < 20; i++){
		listaAlunos[i].codigo = rand() % 999;
		listaAlunos[i].n1 = rand() % 10;
		listaAlunos[i].n2 = rand() % 10;
		listaAlunos[i].n3 = rand() % 10;
		listaAlunos[i].media = (listaAlunos[i].n1 + listaAlunos[i].n2 + listaAlunos[i].n3) / 3;
		
		printf("%d\t %.2f\t %.2f\t %.2f\t %.2f\n", listaAlunos[i].codigo, listaAlunos[i].n1, listaAlunos[i].n2, listaAlunos[i].n3, listaAlunos[i].media);
	}

	
	
	
	
	return 0;
}
