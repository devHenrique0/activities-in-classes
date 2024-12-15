
package henriquep3;
import java.util.Scanner;

public class HenriqueP3 {

    
    public static void main(String[] args) {
       
        String vendedor[] = {"Bia", "Deo", "Leo", "Nai", "Rui", "Ivo", "Gil", "Ian", "Ana"};
        char categoria [] = {'a', 'c', 'b', 'a', 'c', 'b', 'a', 'c', 'b'};
        double valorVendas [] = {40000.00, 60000.00, 20000.00, 30000.00, 80000.00, 50000.00, 10000.00, 70000.00, 80000.00};
        
        Vendedor ven[] = new Vendedor[9];
        System.out.printf("%10s %10s %10s\n", "Vendedor", "Categoria", "Valor Vendas");
        
        for (int i = 0; i < ven.length; i++) {
            ven[i] = new Vendedor();
            ven[i].vendedor = vendedor[i];
            ven[i].categoria = categoria[i];
            ven[i].valorVendas = valorVendas[i];
            System.out.printf("%10s %10c %10.2f\n", ven[i].vendedor, ven[i].categoria, ven[i].valorVendas);
        }
        
        int opcao;
         Scanner scan = new Scanner(System.in);
         
        do{
            System.out.println("\n Menu \n"
                    + "1- Meta\n"
                    + "2- Maior Media\n"
                    + "3- Sair\n"
                    + "Digite a opcao desejada: ");
                    opcao = scan.nextInt();
                    
            switch (opcao){
                case 1:
                    System.out.println("Digite um valor para a meta de vendas");
                    double metaVendas = scan.nextDouble();
                    
                    
                    
                    
                    int achou = 0;
                    for (int i = 0; i < valorVendas.length; i++) {
                        
                        if (ven[i].valorVendas >= metaVendas) {
                            
                            
                            System.out.printf("%10s %10c %10.2f\n ", ven[i].vendedor, ven[i].categoria, ven[i].valorVendas);
                            achou = 1;
                            }
                    }
                    if (achou == 0){
                            System.out.println("Meta não atingida");
                        }
                    
                    
                break;
                
                case 2: 
                    int conta= 0,
                        contb = 0,
                        contc = 0;
                    double somaa = 0,
                           somab = 0,
                           somac = 0;
                    for (int i = 0; i < ven.length; i++) {
                        
                        if (ven[i].categoria == 'a') {
                            conta = conta + 1;
                            somaa = somaa + ven[i].valorVendas;
                        } else if (ven[i].categoria == 'b') {
                            contb = contb + 1;
                            somab = somab + ven[i].valorVendas;
                        } else {
                            contc = contc + 1;
                            somac = somac + ven[i].valorVendas;
                        }
                    }
                    double mediaa = somaa / conta;
                    double mediab = somab/ contb;
                    double mediac = somac / contc;

                    System.out.println("Média de categoria A: " + mediaa);
                    System.out.println("Média de categoria B: " + mediab);
                    System.out.println("Média de categoria C: " + mediac);
                    
                    System.out.println("Maior média foi a categoria C: "+ mediac);
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
