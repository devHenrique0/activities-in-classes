#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Definindo a struct Produto
struct Produto {
    int codigo;
    float valor_unitario;
    int quantidade;
};

// Função que recebe o ponteiro da struct e atribui valores aleatórios
void atribuirValores(struct Produto *p) {
    p->codigo = rand() % 1000; // Código aleatório entre 0 e 999
    p->valor_unitario = (float)(rand() % 10000) / 100; // Valor unitário aleatório entre 0.00 e 100.00
    p->quantidade = rand() % 100; // Quantidade aleatória entre 0 e 99
}

int main() {
    srand(time(NULL)); // Semente para gerar números aleatórios

    // Declarando uma variável do tipo struct Produto
    struct Produto novoProduto;

    // Criando um ponteiro do tipo struct Produto e atribuindo o endereço de novoProduto
    struct Produto *p = &novoProduto;

    // Atribuindo valores aleatórios ao produto por meio do ponteiro
    atribuirValores(p);

    // Mostrando o endereço de memória do ponteiro p
    printf("Endereço de memória do ponteiro p: %p\n", (void *)p);

    // Mostrando o conteúdo da struct acessada pelo ponteiro p
    printf("Conteúdo do produto via ponteiro p:\n");
    printf("Código: %d\n", p->codigo);
    printf("Valor unitário: %.2f\n", p->valor_unitario);
    printf("Quantidade: %d\n", p->quantidade);

    // Mostrando o conteúdo da variável novoProduto
    printf("\nConteúdo da variável novoProduto:\n");
    printf("Código: %d\n", novoProduto.codigo);
    printf("Valor unitário: %.2f\n", novoProduto.valor_unitario);
    printf("Quantidade: %d\n", novoProduto.quantidade);

    return 0;
}

