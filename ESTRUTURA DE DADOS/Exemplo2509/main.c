#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAM_APOSTA 6 // Quantidade de números na aposta
#define MAX_NUM 60   // Limite dos números

int ja_Existe(int numeros[], int tam, int num);
void gerar_Numeros(int numeros[]);
void mostrar_numeros(int numeros[]);
int verificar_acertos(int aposta[], int sorteio[]);

int main(){
	int aposta[TAM_APOSTA] = {0}, sorteio[TAM_APOSTA] = {0};
	
	srand(time(NULL));
	
	printf("Aposta: ");
	gerar_Numeros(aposta);
	mostrar_numeros(aposta);
	
	printf("Sorteio: ");
	gerar_Numeros(sorteio);
	mostrar_numeros(sorteio);
	
	int acertos = verificar_acertos(aposta, sorteio);
	printf("Numero de acertos: %d\n", acertos);
	return 0;
}

int ja_Existe(int numeros[], int tam, int num){
	int i;
	for(i = 0; i < tam; i++){
		if(numeros[i] == num){
			return 1;
		}
	}
	return 0;
}

void gerar_Numeros(int numeros[]){
	int num, i;
	for(i = 0; i < TAM_APOSTA; i++){
		do{
			num = rand() % MAX_NUM + 1;
		}while(ja_Existe(numeros, i, num));
		numeros[i] = num;
	}
}

void mostrar_numeros(int numeros[]){
	int i; 
	for(i = 0; i < TAM_APOSTA; i++){
		printf("%d ", numeros[i]);
	}
	printf("\n");
}

int verificar_acertos(int aposta[], int sorteio[]){
	int acertos = 0, i;
	for(i = 0; i = TAM_APOSTA; i++){
		if(ja_Existe(sorteio, TAM_APOSTA, aposta[i])){
			acertos++;
		}
	}
	return acertos;
}
