
package exercicio3prova;
import java.util.Scanner;

public class Exercicio3Prova {

   
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
               
        String cliente [] = {"Bia", "Ivo", "Leo", "Bia", "Leo", "Leo", "Luis", "Lia", "Iumi", "Ivo"};
        char categoria [] = {'p', 'j', 'c', 'j', 'p', 'f', 'p', 'f', 'f', 'c'};
        int qtdHoras [] = {10,4,16,12,40,8,20,10,7,30};
        double valorServico[] = {30,10,40,10,30,20,30,20,20,40};
        String nome;
        double valorTotal;
        int opcao;
        do{
            System.out.println("\nMenu\n"
                    + "1- Pesquisa por clientes\n"
                    + "2- Porcentagem retornos\n"
                    + "3- Sair\n"
                    + "Digite a opcao desejada");
                    opcao = scan.nextInt();
            switch (opcao){
                case 1:
            System.out.println("Digite o nome de um cliente: ");
            nome = scan.next();
            System.out.println("Valor pagos por "+nome);
            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i].equals(nome)){
                    valorTotal = valorServico[i] * qtdHoras[i];
                    System.out.println(categoria[i]+" "+valorTotal);
                }
            }
            break;
            case 2:
                    System.out.print("Digite a categoria de serviço (p, j, c, f): ");
                    char categoriaBuscada = scan.next().charAt(0);
                    double valorTotalPorCategoria = 0;
                    for (int i = 0; i < categoria.length; i++) {
                        if (categoria[i] == categoriaBuscada) {
                            valorTotalPorCategoria += valorServico[i] * qtdHoras[i];
                        }
                    }
                    System.out.println("Valor total recebido na categoria " + categoriaBuscada + ": R$" + valorTotalPorCategoria);
                    break;
                case 3:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
       
        }while(opcao != 3);
    
}
}
