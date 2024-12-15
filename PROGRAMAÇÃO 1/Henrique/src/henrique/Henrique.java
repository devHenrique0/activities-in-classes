package henrique;
import java.util.Scanner;

public class Henrique {

   
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        
        String cliente [] = {"Ana", "Luis", "Bia", "Ivo", "Ana", "Luis", "Bia", "Ana", "Bia", "Ian"};
        double valorBase [] = {400.00, 700.00,200.00,900.00,500.00,800.00,100.00,600.00,300.00,150.00};
        int numPrestacoes [] = {1,2,1,3,2,3,1,3,2,1};
        
        for (int i = 0; i < cliente.length; i++) {
            System.out.printf("\n %10s %10.2f %10d", cliente[i], valorBase[i], numPrestacoes[i]);
        }
        
        int opcao;
        String nome;
        double valorTotal  = 0;
        int contador = 0;
        int contad = 0;
        int contt = 0;
        do{
            System.out.println("\n Menu \n"
                    + "1- Pesquisa por cliente\n"
                    + "2- Porcentagem\n"
                    + "3- Sair\n"
                    + "Digite a opcao desejada: ");
                    opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o nome de um cliente");
                    nome = scan.next();
            
            for (int i = 0; i < cliente.length; i++) {
                if (cliente[i].equals(nome)){
                    valorTotal += valorBase[i];
                    System.out.println(cliente[i]+" suas compras sao "+valorBase[i]);
                }
            }
            System.out.println("O valor total e "+valorTotal);
                break;
                
                case 2: 
                   
                    for (int i = 0; i < numPrestacoes.length; i++) {
                        if (1 == numPrestacoes[i]){
                            contador++;
                        }
                        else if (2 == numPrestacoes[i]){
                            contad++;
                        }
                        else if (3 == numPrestacoes[i]){
                            contt++;
                        }
                    }
                    double total1 = 0;
                    total1 = (double) contador / numPrestacoes.length * 100;
                    System.out.println("A porcentagem das pessoas que compraram a vista e "+total1+"%");
                    double total2 = 0;
                    total2 = (double) contad / numPrestacoes.length * 100;
                    System.out.println("A porcentagem das pessoas que parcelaram em duas vezes e "+total2+"%");
                    double total3 = 0;
                    total3 = (double) contt / numPrestacoes.length * 100;
                    System.out.println("A porcentagem das pessoas que parcelaram em tres vezes e "+total3+"%");
                break;
                
                case 3:
                    System.out.println("Comando encerrado");
                break;
                
                default:
                    System.out.println("Opcao invalida");
            }
        }while(opcao != 3);
    }
    
}
