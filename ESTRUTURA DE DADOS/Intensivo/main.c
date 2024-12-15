#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct reserva {
    int numReserva;
    char nomeCliente[50];
    int numQuarto;
    float valorEstadia;
};

typedef struct reserva Reserva;

struct elemento {
    struct reserva dados;
    struct elemento *proximo;
    struct elemento *anterior;
};

typedef struct elemento Elemento;
typedef struct elemento* Lista;

// Protótipos
Lista* criarLista();
int inserirInicio(Lista *lista, Reserva novaReserva);
int inserirFim(Lista *lista, Reserva novaReserva);
int removerInicioLista(Lista *lista);
int removerFimLista(Lista *lista);
void imprimirLista(Lista *lista);
void imprimirListaReversa(Lista *lista);
void liberaLista(Lista *lista);
int tamanhoLista(Lista *lista);
float calcularMedia(Lista *lista);

int main() {
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
    printf("\nO valor médio das estadias é: %.2f\n", 
	calcularMedia(listareservas));

    printf("\nLista na ordem reversa:\n");
    imprimirListaReversa(listareservas);

    removerInicioLista(listareservas);
    removerFimLista(listareservas);

    printf("\nTamanho da lista: %d\n", 
	tamanhoLista(listareservas));

    imprimirLista(listareservas);

    liberaLista(listareservas);

    return 0;
}

Lista* criarLista() {
    Lista *lista = (Lista*) malloc(sizeof(Lista));
    if (lista != NULL) {
        *lista = NULL;
    }
    return lista;
}

int inserirInicio(Lista *lista, Reserva novaReserva) {
    if (lista == NULL) {
        return 0;
    }

    Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
    if (novoElemento == NULL) {
        return 0;
    }

    novoElemento->dados = novaReserva;
    novoElemento->proximo = (*lista);
    novoElemento->anterior = NULL;

    if (*lista != NULL) {	
        (*lista)->anterior = novoElemento;
    }

    *lista = novoElemento;
    return 1;
}

int inserirFim(Lista *lista, Reserva novaReserva) {
    if (lista == NULL) {
        return 0;
    }

    Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
    if (novoElemento == NULL) {
        return 0;
    }

    novoElemento->dados = novaReserva;
    novoElemento->proximo = NULL;

    if (*lista == NULL) {
        novoElemento->anterior = NULL;
        *lista = novoElemento;
    } else {
        Elemento *aux = *lista;
        while (aux->proximo != NULL) {
            aux = aux->proximo;
        }
        aux->proximo = novoElemento;
        novoElemento->anterior = aux;
    }
    return 1;
}

int removerInicioLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 0;
    }

    Elemento *aux = *lista;
    *lista = aux->proximo;

    if (*lista != NULL) {
        (*lista)->anterior = NULL;
    }

    free(aux);
    return 1;
}

int removerFimLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 0;
    }

    Elemento *aux = *lista;

    while (aux->proximo != NULL) {
        aux = aux->proximo;
    }

    if (aux->anterior == NULL) {
        *lista = NULL;
    } else {
        aux->anterior->proximo = NULL;
    }

    free(aux);
    return 1;
}

void imprimirLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia ou inexistente.\n");
        return;
    }

    Elemento *aux = *lista;
    printf("\n+++++ Lista de Reservas +++++\n");
    while (aux != NULL) {
        printf(" Número da Reserva: %d\n", aux->dados.numReserva);
        printf(" Nome do Cliente: %s\n", aux->dados.nomeCliente);
        printf(" Número do Quarto: %d\n", aux->dados.numQuarto);
        printf(" Valor da Estadia: %.2f\n\n", aux->dados.valorEstadia);
        aux = aux->proximo;
    }
}

void imprimirListaReversa(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia ou inexistente.\n");
        return;
    }

    Elemento *aux = *lista;
    while (aux->proximo != NULL) {
        aux = aux->proximo;
    }

    printf("\n+++++ Lista Reversa de Reservas +++++\n");
    while (aux != NULL) {
        printf(" Número da Reserva: %d\n", aux->dados.numReserva);
        printf(" Nome do Cliente: %s\n", aux->dados.nomeCliente);
        printf(" Número do Quarto: %d\n", aux->dados.numQuarto);
        printf(" Valor da Estadia: %.2f\n\n", aux->dados.valorEstadia);
        aux = aux->anterior;
    }
}

void liberaLista(Lista *lista) {
    if (lista != NULL) {
        Elemento *aux;
        while (*lista != NULL) {
            aux = *lista;
            *lista = (*lista)->proximo;
            free(aux);
        }
        free(lista);
    }
}

int tamanhoLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 0;
    }

    int count = 0;
    Elemento *aux = *lista;

    while (aux != NULL) {
        count++;
        aux = aux->proximo;
    }

    return count;
}

float calcularMedia(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        printf("Lista vazia ou inexistente.\n");
        return 0.0;
    }

    float soma = 0.0;
    int count = 0;
    Elemento *aux = *lista;

    while (aux != NULL) {
        soma += aux->dados.valorEstadia;
        count++;
        aux = aux->proximo;
    }

    return (count > 0) ? (soma / count) : 0.0;
}

