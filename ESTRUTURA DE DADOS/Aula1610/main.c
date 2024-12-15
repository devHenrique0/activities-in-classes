#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct aluno {
    int matricula;
    char nome[30];
    float nota1;
    float nota2;
    float nota3;
};

typedef struct aluno Aluno;

struct elemento {
    struct aluno dados;
    struct elemento *proximo;
};

typedef struct elemento* Lista;

typedef struct elemento Elemento;

// Protótipos
Lista* criarLista();
int inserirInicioLista(Lista *lista, Aluno novoAluno);
void imprimirLista(Lista *lista);
int removerInicioLista(Lista* lista);
int inserirFim(Lista *lista, Aluno novoAluno);
void liberaLista(Lista* lista);
int tamanhoDaLista(Lista *lista);
int listaVazia(Lista *lista);
int removerFimLista(Lista *lista);

int main() {
    Aluno a1 = {555, "Aluno1", 3.1, 4.8, 5.9};
    Aluno a2 = {556, "Aluno2", 3.1, 4.8, 5.9}; 
    Aluno a3 = {557, "Aluno3", 3.1, 4.8, 5.9};
    Aluno a4 = {558, "Aluno4", 3.1, 4.8, 5.9};
    Aluno a5 = {559, "Aluno5", 3.1, 4.8, 5.9};
    
    Lista *listaAlunos = criarLista();
    
    inserirInicioLista(listaAlunos, a1);
    inserirInicioLista(listaAlunos, a2);
    inserirInicioLista(listaAlunos, a3);
    
    inserirFim(listaAlunos, a4);
    inserirFim(listaAlunos, a5);
    
    imprimirLista(listaAlunos);
    
    printf("\nTamanho da lista: %d\n", tamanhoDaLista(listaAlunos));
    
    removerInicioLista(listaAlunos);
    removerFimLista(listaAlunos);
    
    imprimirLista(listaAlunos);
    liberaLista(listaAlunos);
    
    
    return 0;
}

Lista* criarLista() {
    Lista *lista = (Lista*) malloc(sizeof(Lista));
    if (lista != NULL) {
        *lista = NULL;
    }
    return lista;
}

int inserirInicioLista(Lista *lista, Aluno novoAluno) {
    if (lista == NULL) {
        return 0;
    }
    
    Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
    if (novoElemento == NULL) {
        return 0;
    }
    
    novoElemento->dados = novoAluno;
    novoElemento->proximo = (*lista);
    *lista = novoElemento;
    return 1;
}

void imprimirLista(Lista *lista) {
    if (lista == NULL) {
        printf("Lista Nula\n");
        return;
    }
    
    Elemento *auxiliar = *lista;
    printf("\n###### LISTA DE ALUNOS ######\n");
    while (auxiliar != NULL) {
        printf("\nMatricula: %d", auxiliar->dados.matricula);
        printf("\nNome: %s", auxiliar->dados.nome);
        printf("\nNota 1: %.2f", auxiliar->dados.nota1);
        printf("\nNota 2: %.2f", auxiliar->dados.nota2);
        printf("\nNota 3: %.2f", auxiliar->dados.nota3);
        printf("\n-----------------------------");
        
        auxiliar = auxiliar->proximo;
    }
    printf("\n");
}

int inserirFim(Lista *lista, Aluno novoAluno) {
    if (lista == NULL) {
        return 0;
    }
    
    Elemento *novoElemento = (Elemento*) malloc(sizeof(Elemento));
    if (novoElemento == NULL) {
        return 0;
    }
    
    novoElemento->dados = novoAluno;
    novoElemento->proximo = NULL;
    
    if ((*lista) == NULL) {
        *lista = novoElemento;
    } else {
        Elemento *auxiliar = *lista;
        while (auxiliar->proximo != NULL) {
            auxiliar = auxiliar->proximo;
        }
        auxiliar->proximo = novoElemento;
    }
    return 1;
}

void liberaLista(Lista* lista) {
    if (lista != NULL) {
        Elemento *elemento;
        while (*lista != NULL) {
            elemento = *lista;
            *lista = (*lista)->proximo;
            free(elemento);
        }
        free(lista);
    }
}

int tamanhoDaLista(Lista *lista) {
    if (lista == NULL) {
        return 0;
    }
    
    int cont = 0;
    Elemento *elemento = *lista;
    while (elemento != NULL) {
        cont++;
        elemento = elemento->proximo;
    }
    return cont;
}

int listaVazia(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 1;
    }
    return 0;
}

int removerInicioLista(Lista* lista) {
    if (lista == NULL || *lista == NULL) {
        return 0;
    }
    
    Elemento *auxiliar = *lista;
    *lista = auxiliar->proximo;
    free(auxiliar);
    return 1;
}

int removerFimLista(Lista *lista) {
    if (lista == NULL || *lista == NULL) {
        return 0;
    }
    
    Elemento *ultimoElemento = *lista;
    Elemento *elementoAnterior = NULL;
    
    while (ultimoElemento->proximo != NULL) {
        elementoAnterior = ultimoElemento;
        ultimoElemento = ultimoElemento->proximo;
    
    if (ultimoElemento == *lista) {
        *lista = NULL;
    } else {
        elementoAnterior->proximo = NULL;
    }
    
    free(ultimoElemento);
    return 1;
}
}

