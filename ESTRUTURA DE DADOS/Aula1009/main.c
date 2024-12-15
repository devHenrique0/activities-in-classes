#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define TAMANHO 100

//Prototipo
int buscaLinear(int v[], int n, int chave);
void preencherArray(int *v, int n);
void imprimir(int *v, int n);
void ordenarBubbleSource(int a[], int b);

int main(int argc, char *argv[]) {
	
	srand(time(NULL));
	
	int dados[TAMANHO];
	
	preencherArray(dados, TAMANHO);
	//imprimir(dados, TAMANHO);
	
	clock_t inicio = clock();
	printf("Linear: %d", buscaLinear(dados, TAMANHO, 1245));
	clock_t fim = clock();
	
	double total = (double) (fim - inicio) / CLOCKS_PER_SEC;
	printf("\n Tempo busca sequencial: %lf", total);
	
	ordenarBubbleSource(dados, TAMANHO);
	//imprimir(dados, TAMANHO);
	
	inicio = clock();
	printf("\n\nBusca Ordenada: %d", buscaOrdenada(dados, TAMANHO, 29));
	fim = clock();
	
	total = (double) (fim - inicio) / CLOCKS_PER_SEC;
	printf("\nTempo de busca ordenada: %lf", total);

	inicio = clock();
	printf("\n\n Busca Binaria: %d", buscaBinaria(dados, TAMANHO, 29));
	fim = clock();

	total = (double) (fim - inicio) / CLOCKS_PER_SEC;
	printf("\nTempo de busca binaria: %lf", total);
	
		
	return 0;
}

int buscaLinear(int *V, int N, int elem){
	int i;
	for(i = 0; i < N; i++){
		if(elem == V[i])
		return i;
	}
	return -1;
}

void preencherArray(int *v, int n){
	int i;
	
	for(i = 0; i < n; i++){
		v[i] = rand () % 50;
	}
}

void imprimir(int *v, int n){
	int i;
	printf("\n\n####### Arrayzinho #######\n");
	for(i = 0; i < n; i++){
		printf("%d \n", v[i]);
	}
}

int buscaOrdenada(int v[], int n, int chave){
	int i;
	for(i = 0; i < n; i++){
		if(v[i] == chave){
			return i;
		}else{
			if(v[i] > chave){
				return -1; // n o h  elemento   frente
			}
		}
	}	
}

void ordenarBubbleSource (int v[], int n){
	int i,k;
	for(k = 0 ; k < n ; k++){
		for(i = 0; i < n - 1; i++){
		
		if(v[i] > v[i+1]){
			int aux = v[i];
			v[i] = v[i+1];
			v[i+1] = aux;
			}
		}
	}
}		

int buscaBinaria(int *V, int N, int elem){
	int i, inicio, meio, final;
	inicio = 0;
	final = N - 1;
	while(inicio <= final){
		meio = (inicio + final) / 2;
		if(elem <V[meio])
		final = meio-1;
		else
		if(elem > V[meio])
		inicio = meio+1;
		else
		return meio;
	}
	return -1;
}
