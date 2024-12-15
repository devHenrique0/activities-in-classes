	#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

struct disciplina{
	int codigo;
	float nota1;
	float nota2;
	float media;
};

struct aluno{
	int ra;
	char nome[50];
	struct disciplina Disciplina;
};

int main(int argc, char *argv[]) {
	struct aluno listaAluno;
	struct disciplina listaDisciplina[5];
	int i;
	float soma = 0, somaFim = 0;
	
	
	printf("Digite seu nome: ");
	scanf("%s", &listaAluno.nome);
	printf("Digite seu RA: ");
	scanf("%d", &listaAluno.ra);
	for(i = 0; i <= 4; i++){
		listaDisciplina[i].codigo = rand() % 999;
		listaDisciplina[i].nota1 = rand() % 10;
		listaDisciplina[i].nota2 = rand() % 10;
		listaDisciplina[i].media = (listaDisciplina[i].nota1 + listaDisciplina[i].nota2) / 2;
		
		soma += listaDisciplina[i].media;
		somaFim = soma / i;
		
		printf("Codigo - %d - da Media - %d: %.2f \n",listaDisciplina[i].codigo,i, listaDisciplina[i].media);
		
	}
	printf("%s seu RA e correspondente a - %d - e a sua Media Geral: %.2f\n",listaAluno.nome, listaAluno.ra, somaFim);
	
	
	return 0;
}
