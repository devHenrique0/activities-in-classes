
package lojaestoqueminimo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LojaEstoqueMinimo {

   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            List<Produto> prod = lerdados();
            for (Produto p: prod) {
                System.out.println(p.toString());
            }
                int opcao;
                do{
                    System.out.println("\n Menu \n"
                            + "1 – Efetuar venda\n"
                            + "2 – Verificar estoque\n"
                            + "3 – Sair\n"
                            + "Digite a opção desejada: \n");
                    opcao = scan.nextInt();
                    
                    switch(opcao){
                        case 1:
                            System.out.println("Digite o código");
                            int cod = scan.nextInt();
                            
                            boolean achou = false;
                            for (Produto p: prod) {
                                if(cod == p.getCodigo()){
                                    achou = true;
                                    System.out.println("Digite a quantidade");
                                    int qtd = scan.nextInt();
                                    if(p.temEstoque(qtd)){
                                        System.out.println("Valor: "+p.calcvalor(qtd));
                                    }
                                }
                            }
                            if(!achou ){
                                System.out.println("Código Inválido");
                            }
                            
                        break;
                        case 2:
                            for (Produto p: prod) {
                                System.out.println(p.getDescricao()+"   "+p.verificaEstoque());
                            }
                        break;
                        case 3:
                            System.out.println("Opcao Invalida");
                        break;
                    }
                }while(opcao != 3);
            
    
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
    }
    
    public static List<Produto> lerdados() throws FileNotFoundException{
        File fil = new File("dados");
        Scanner scan = new Scanner(fil);
        
        List<Produto> produtos = new ArrayList<>();
        
        while(scan.hasNext()){
            Produto prod = new Produto(scan.nextInt(),scan.next(),scan.nextInt(),scan.nextInt(),scan.nextDouble());
            produtos.add(prod);
        }
        return produtos;
    }
}

//Crie uma classe para manter os dados do produto e para realizar tarefas:

//1) Declare campos para cada coluna da tabela, todos private, crie métodos get e set para eles. Crie um construtor que receba
//os atributos do produto, como parâmetros, e armazene-os nos campos da classe. Sobrecarregue o método toString para
//fornecer uma saída formatada e exibir os dados como na tabela acima.
//
//2) Implemente um método para verificar se há estoque: este método recebe a quantidade a ser vendida e retorna true se o
//estoque for suficiente ou false, caso contrário. 
//
//3) Implemente um método para método para realizar uma venda: este método recebe a quantidade a ser vendida, dá baixa no
//estoque, calcula e retorna o valor a ser pago pelo cliente. 
//
//4) Implemente um método para verificar a situação do estoque: este método retorna uma das seguintes mensagens: “Estoque
//normal” se o estoque for maior que o estoque mínimo, “Estoque crítico” se o estoque for igual ao estoque mínimo ou “Estoque
//baixo” se o estoque for menor que o estoque mínimo. 
//
//5) Na classe principal, implemente um método para ler os dados dos produtos em um arquivo de texto, armazenar em um vetor
//de produtos e exibir na tela. 
//No método main,
//
//6) Crie vetor para armazenar os dados e chame o método que carrega e exibe os dados, passando o vetor. 
//Crie o seguinte menu de opções (incluir mensagem de opção inválida, com a cláusula default): 
//                                Menu
//                            1 – Efetuar venda
//                            2 – Verificar estoque
//                            3 – Sair
//                            Digite a opção desejada:
//
//7) Na opção 1, solicite que o usuário digite o código do produto. Se o código informado for válido, solicite que o usuário digite
//a quantidade desejada, verifique se há estoque (chamando o método implementado no item 2) e, se houver, efetue a venda e
//exiba o valor a ser pago pelo cliente (use o método do item 3). Se o estoque não for suficiente, exiba a mensagem “Estoque
//suficiente”. Se o código informado for inválido, exiba a mensagem “Código inexistente”. 
//
//8) Na opção 2, exiba as descrições dos produtos e sua situação no estoque. 
//
//9) Na opção 3, escreva a mensagem “Encerrando o sistema”.
//
//10) Sobre variáveis de parâmetro, explique qual é o seu propósito, diga onde são declaradas e diga como são inicializadas. 
