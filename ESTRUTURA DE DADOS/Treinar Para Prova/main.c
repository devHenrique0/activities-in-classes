#include <stdio.h>
#include <stdlib.h>

struct reserva{
	int numReserva;
	char nomeCliente[50];
	int numQuarto;
	float valorEstadia;
};

typedef struct reserva Reserva;

struct elemento{
	struct reserva dados;
	struct elemento *proximo;
};

typedef struct elemento* Lista;

typedef struct elemento Elemento;

//Protótipos
Lista* criarLista();
int inserirInicio(Lista *lista, Reserva novaReserva);
void imprimirLista(Lista *lista);
int inserirFim(Lista *lista, Reserva novaReserva);
void liberaLista(Lista *lista);
int tamanhoLista(Lista *lista);
int removerInicioLista(Lista *lista);
int removerFimLista(Lista *lista);
float calcularMedia(Lista *lista);
void encontrarReservaMaisCara(Lista *lista);
void aplicarDesconto(Lista *lista, float limite, float descontoPercentual);


int main(int argc, char *argv[]) {
	
	Reserva R1 = {154, "Alfred", 32, 187.90};
	Reserva R2 = {152, "Batman", 16, 199.90};
	Reserva R3 = {150, "Robin", 8, 119.90};
	Reserva R4 = {148, "Pinguim", 4, 101.90};
	
	Lista *listareservas = criarLista();
	
	inserirInicio(listareservas, R1);
	inserirInicio(listareservas, R2);
	
	inserirFim(listareservas, R3);
	inserirFim(listareservas, R4);
	
	imprimirLista(listareservas);
	
	float limite, desconto;
	printf("\nDigite o limite para aplicar desconto: ");
	scanf("%f", &limite);
	printf("Digite o percentual de desconto: ");
	scanf("%f", &desconto);
	aplicarDesconto(listareservas, limite, desconto);

	
	printf("\nO valor Medio de valor de estadia e de: %.2f", 
	calcularMedia(listareservas));
	
	encontrarReservaMaisCara(listareservas);
	
	removerInicioLista(listareservas);
	removerFimLista(listareservas);
	
	printf("\n\nO tamanho da Lista e: %d\n", 
	tamanhoLista(listareservas));
	
	imprimirLista(listareservas);
	liberaLista(listareservas);
	
	
	return 0;
}

Lista* criarLista() {
	Lista *lista = (Lista*) malloc(sizeof(Lista));
	if(lista != NULL){
		*lista = NULL;
	}
}

int inserirInicio(Lista *lista, Reserva novaReserva){
	if(lista == NULL){
		return 0;
	}
	
	Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
	if(novoElemento == NULL){
		return 0;
	}
	
	novoElemento->dados = novaReserva;
	novoElemento->proximo = (*lista);
	*lista = novoElemento;
}

void imprimirLista(Lista *lista){
	if(lista == NULL){
		printf("Lista Nula\n");
		return;
	}
	
	Elemento *aux = *lista;
	printf("\n+++++ Lista de Reservas +++++");
	while(aux != NULL){
		printf("\n Numero da Reserva: %d", aux->dados.numReserva);
		printf("\n Nome do Cliente: %s", aux->dados.nomeCliente);
		printf("\n Numero do Quarto: %d", aux->dados.numQuarto);
		printf("\n Valor da Estadia: %2.f", aux->dados.valorEstadia);
		printf("\n");
		aux = aux->proximo;
	}
	printf("\n");
}

int inserirFim(Lista *lista, Reserva novaReserva){
	if(lista == NULL){
		return 0;
	}
	
	Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
	if(novoElemento == NULL){
		return 0;
	}
	
	novoElemento->dados = novaReserva;
	novoElemento->proximo = NULL;
	
	if((*lista) == NULL){
		*lista = novoElemento;
	}else{
		Elemento *aux = *lista;
		while(aux->proximo != NULL){
			aux = aux->proximo;
		}
		aux->proximo = novoElemento;
	}
	return 1;
}

void liberaLista(Lista *lista){
	if(lista != NULL){
		Elemento *elemento;
		while(*lista != NULL){
			elemento = *lista;
			*lista = (*lista)->proximo;
			
			free(elemento);
		}
		free(lista);
	}
}

int tamanhoLista(Lista *lista){
	if(lista == NULL){
		return 0;
	}
	
	int cont = 0;
	Elemento *elemento = *lista;
	while(elemento != NULL){
		cont++;
		elemento = elemento->proximo;
	}
	return cont;
}

int removerInicioLista(Lista *lista){
	if(lista == NULL || *lista == NULL){
		return 0;
	}
	
	Elemento *aux = *lista;
	*lista = aux->proximo;
	free(aux);
	return 1;
}

int removerFimLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 0; // Lista vazia ou inexistente
    }

    Elemento *ultimoElemento = *lista;
    Elemento *elementoAnterior = NULL;

    // Percorrer até o último elemento
    while (ultimoElemento->proximo != NULL) {
        elementoAnterior = ultimoElemento;
        ultimoElemento = ultimoElemento->proximo;
    }

    if (elementoAnterior == NULL) {
        // Caso especial: a lista tem apenas um elemento
        *lista = NULL;
    } else {
        // Remove o último elemento
        elementoAnterior->proximo = NULL;
    }

    free(ultimoElemento);
    return 1;
}

// Função para calcular a média de preços
float calcularMedia(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia!\n");
        return 0.0;
    }

    float soma = 0.0;
    int count = 0;
    Elemento *atual = *lista;

    while (atual != NULL) {
        soma += atual->dados.valorEstadia;
        count++;
        atual = atual->proximo;
    }

    if (count == 0) {
        return 0.0; // Evitar divisão por zero
    }

    return soma / count;
}

void encontrarReservaMaisCara(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia ou inexistente.\n");
        return;
    }

    Elemento *atual = *lista;
    Elemento *maisCara = *lista;

    while (atual != NULL) {
        if (atual->dados.valorEstadia > maisCara->dados.valorEstadia) {
            maisCara = atual;
        }
        atual = atual->proximo;
    }

    printf("\n+++++ Reserva Mais Cara +++++\n");
    printf(" Numero da Reserva: %d\n", maisCara->dados.numReserva);
    printf(" Nome do Cliente: %s\n", maisCara->dados.nomeCliente);
    printf(" Numero do Quarto: %d\n", maisCara->dados.numQuarto);
    printf(" Valor da Estadia: %.2f\n", maisCara->dados.valorEstadia);
}

void aplicarDesconto(Lista *lista, float limite, float descontoPercentual) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia ou inexistente.\n");
        return;
    }

    Elemento *atual = *lista;
    printf("\n+++++ Aplicando desconto nas reservas acima de %.2f +++++\n", limite);

    while (atual != NULL) {
        if (atual->dados.valorEstadia > limite) {
            float valorOriginal = atual->dados.valorEstadia;
            atual->dados.valorEstadia -= atual->dados.valorEstadia * (descontoPercentual / 100.0);
            printf("Reserva %d: Valor original = %.2f, Novo valor = %.2f\n",
                   atual->dados.numReserva, valorOriginal, atual->dados.valorEstadia);
        }
        atual = atual->proximo;
    }
}







