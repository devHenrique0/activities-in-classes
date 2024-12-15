
package exercicio2prova;
import java.util.Scanner;

public class Exercicio2Prova {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String cliente [] = {"Bia", "Ivo", "Leo", "Bia", "Leo", "Leo", "Luis", "Lia", "Iumi", "Ivo"};
        char categoria [] = {'p', 'j', 'c', 'j', 'p', 'f', 'p', 'f', 'f', 'c'};
        int qtdHoras [] = {10,4,16,12,40,8,20,10,7,30};
        double valorServico[] = {30,10,40,10,30,20,30,20,20,40};
        
        for (int i = 0; i < cliente.length; i++) {
            System.out.printf("\n %10s %10c %10d", cliente[i], categoria[i], qtdHoras[i]);
        }
        char categoriaBuscada;
        int opcao;
        double valortotal;
        do{
            
        System.out.println("\n Menu\n"
                + "1- Valores a ser recebido\n"
                + "2- Pesquisa por categoria\n"
                + "3- Sair\n"
                + "Digite a opcao desejada:");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1: 
                        for (int i = 0; i < cliente.length; i++) {
                            valortotal = valorServico[i] * qtdHoras[i];
                            System.out.println(cliente[i]+" - $"+valortotal);
                        }
                        
                    break;
                    case 2:
                        double soma = 0;
                        System.out.println("Digite a categoria a ser pesquisada");
                        categoriaBuscada = scan.next().charAt(0);
                        
                        for (int i = 0; i < cliente.length; i++) {
                            if(categoria[i] == categoriaBuscada){
                                soma += valorServico[i] * qtdHoras[i];
                            } 
                        }
                        System.out.println("O valor dessa categoria e " +soma);
                    break;
                    
                    case 3: 
                        System.out.println("Comando encerrado");
                    break;
                    
                    default: 
                        System.out.println("Opcao invalida!");
                }
        }while(opcao != 3);
        
    }
    
}
