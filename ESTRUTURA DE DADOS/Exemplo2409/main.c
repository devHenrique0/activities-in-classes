#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Definindo a struct Produto
struct Produto {
    int codigo;
    float valor_unitario;
    int quantidade;
};

// Fun��o que recebe o ponteiro da struct e atribui valores aleat�rios
void atribuirValores(struct Produto *p) {
    p->codigo = rand() % 1000; // C�digo aleat�rio entre 0 e 999
    p->valor_unitario = (float)(rand() % 10000) / 100; // Valor unit�rio aleat�rio entre 0.00 e 100.00
    p->quantidade = rand() % 100; // Quantidade aleat�ria entre 0 e 99
}

int main() {
    srand(time(NULL)); // Semente para gerar n�meros aleat�rios

    // Declarando uma vari�vel do tipo struct Produto
    struct Produto novoProduto;

    // Criando um ponteiro do tipo struct Produto e atribuindo o endere�o de novoProduto
    struct Produto *p = &novoProduto;

    // Atribuindo valores aleat�rios ao produto por meio do ponteiro
    atribuirValores(p);

    // Mostrando o endere�o de mem�ria do ponteiro p
    printf("Endere�o de mem�ria do ponteiro p: %p\n", (void *)p);

    // Mostrando o conte�do da struct acessada pelo ponteiro p
    printf("Conte�do do produto via ponteiro p:\n");
    printf("C�digo: %d\n", p->codigo);
    printf("Valor unit�rio: %.2f\n", p->valor_unitario);
    printf("Quantidade: %d\n", p->quantidade);

    // Mostrando o conte�do da vari�vel novoProduto
    printf("\nConte�do da vari�vel novoProduto:\n");
    printf("C�digo: %d\n", novoProduto.codigo);
    printf("Valor unit�rio: %.2f\n", novoProduto.valor_unitario);
    printf("Quantidade: %d\n", novoProduto.quantidade);

    return 0;
}

