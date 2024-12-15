#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

struct Aluno{
	char nome[30];
	float P1;
	float P2;
	float media;
	int codigo; 
};

int main(int argc, char *argv[]) {
	int i;
	struct Aluno ListaAlunos[2];
	
	
	
	for(i = 0; i <= 1; i++){
		printf("Digite seu nome: ");
		scanf("%s", &ListaAlunos[i].nome);
		ListaAlunos[i].codigo = rand() % 10;
		ListaAlunos[i].P1 = rand() % 10;
		ListaAlunos[i].P2 = rand() % 10;
		ListaAlunos[i].media = (ListaAlunos[i].P1 + ListaAlunos[i].P2) / 2;
		
		printf("Ola %s, o codigo da sua materia e %d, sua nota na P1 foi %.2f e sua nota na P2 foi %.2f logo sua media foi %.2f\n", 
				ListaAlunos[i].nome, ListaAlunos[i].codigo, ListaAlunos[i].P1, ListaAlunos[i].P2, ListaAlunos[i].media);
	}
	
	return 0;
}
