#include <stdio.h>
#include <stdlib.h>

struct produto{
	int codigo;
	int quantidade;
	float valorUnitario;
};

typedef struct produto Produto;

struct elemento {
	Produto produto;
	struct elemento *anterior;
	struct elemento *proximo;
};

typedef struct elemento Elemento;

typedef struct elemento* Lista;

Lista* criarLista();
int inserirInicio(Lista *lista, Produto novoProduto);
void imprimirListaProdutos(Lista *lista);
int inserirFim(Lista *lista, Produto novoProduto);
int removerIninicio(Lista *lista);


int main(int argc, char *argv[]) {
	
	Produto p1 = {1, 10, 11.99};
	Produto p2 = {2, 20, 19.87};
	Produto p3 = {3, 30, 99.77};
	Produto p4 = {4, 1, 100.01};
	Produto p5 = {5, 3, 93.01};
	
	Lista *listaProdutos = criarLista();
	 inserirInicio(listaProdutos, p1);
	 inserirInicio(listaProdutos, p2);
	 inserirInicio(listaProdutos, p3);
	 inserirFim(listaProdutos, p4);
	 inserirFim(listaProdutos, p5);
	 
	 removerIninicio(listaProdutos);
	 
	 imprimirListaProdutos(listaProdutos);



	return 0;
}

Lista* criarLista(){
	Lista *lista = (Lista*) malloc(sizeof(Lista));
	if(lista != NULL){
		*lista = NULL;
	}
	return lista;
}

int inserirInicio(Lista *lista, Produto novoProduto){
	if(lista == NULL){
		printf("Não existe lista");
		return 0;
	}
	
	Elemento *elemento = (Elemento*) malloc(sizeof(Elemento));
	
	if(elemento == NULL){
		printf("Nao foi possivel alocar memoria");
		return 0;
	}
	
	elemento->produto = novoProduto;
	elemento->proximo = (*lista);
	elemento->anterior = NULL;
	
	if(*lista != NULL){
		(*lista)->anterior = elemento;
	}
	
	*lista = elemento;
	return 1;
}

void imprimirListaProdutos(Lista *lista){
	if(lista == NULL){
	printf("Imprimir: Lista Inexistente");
	return;	
	}
	
	printf("\n..... Lista de Produtos .....");
	printf("\nCodigo | QTD | ValorUni");
	printf("\n.............................");
	
	Elemento *aux = *lista;
	
	while(aux != NULL){
		printf("\n%d\t%d\t%.2f", aux->produto.codigo,
								 aux->produto.quantidade,
								 aux->produto.valorUnitario);
								
	aux = aux->proximo;
	}
	printf("\n--------------------------------------");
}

int inserirFim(Lista *lista, Produto novoProduto){
	if(lista == NULL){
		printf("Inserir no Fim: lista não existe");
		return 0; //False
	}
	
	Elemento *elemento = (Elemento*) malloc(sizeof(Elemento));
	
	if(elemento == NULL){
		printf("Inserir Fim: nao foi possivel alocar memoria :(");
		return 0;
	}
	
	elemento->produto = novoProduto;
	elemento->proximo = NULL;
	
	
	if((*lista) == NULL){
		elemento->anterior = NULL;
		*lista = elemento;
	}else{
		Elemento *aux = *lista;
		
		while(aux->proximo != NULL){
			aux = aux->proximo;
		}
		aux->proximo = elemento;
		elemento->anterior = aux;
	}
	return 1;
}

int removerIninicio(Lista *lista){
	if(lista == NULL){
		return 0;
	}
	
	if(*lista == NULL){
		return 1;
	}
	
	Elemento *aux = *lista;
	*lista = aux->proximo;
	
	if(aux->proximo != NULL){
		aux->proximo->anterior = NULL;
	}
	
	free(aux);

	
	return 1;
}
