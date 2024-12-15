
package exercicioprova;
import java.util.Scanner;

public class ExercicioProva {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        
        String nome[] = {"Rui", "Iumi", "Nei","Susi","Alan","Ian","Bia","Gil"};
        double salarioBase[] = {3000.00,1000.00,800.00,1800.00,1100.00,1500.00,1200.00,900.00 };
        int numDep[] = {4,2,2,0,1,3,3,0};
        
        for (int i = 0; i < nome.length; i++) {
            System.out.printf("\n %10s  %10.2f %10d\n", nome[i], salarioBase[i], numDep[i]);
        }
        int valor, dependentes, contt = 0;
        double totdependentes;
        do {
            System.out.println("Digite o numero de acordo com sua preferencia\n"
                    + "1- Salario final\n"
                    + "2- Percentual por dependente\n"
                    + "3- Sair");
            valor = scan.nextInt();
            
            switch(valor){
            case 1:
                
                for (int i = 0; i < nome.length; i++) {
                 if (salarioBase[i] < 1110){
                    double soma = numDep[i] * 70;
                 
                     double soma1 = soma + salarioBase[i];
                     
                     System.out.println(nome[i] +" " +soma1 + ", voce tem direito a 70 reias por pendente ");
                 }
                 if (salarioBase[i] > 1110 && salarioBase[i] < 1550){
                     double soma2 = numDep[i] * 50;
                     
                     double soma3 = soma2 + salarioBase[i];
                     
                     
                     System.out.println(nome[i] +" "+ soma3 + ", voce tem direito a 50 reais por pendente ");
                     
                }
                 if (salarioBase[i] > 1550) {
                     System.out.println(nome[i] +", voce nao tem direito ao salario familia");
                 }
                 
                }
                
            
           
            break;
            case 2:
                
                System.out.print("Digite o número de dependentes desejado: ");
                dependentes = scan.nextInt();
                contt = 0;
                for (int i = 0; i < nome.length; i++) {
                    if(dependentes < numDep[i] ){
                        contt = contt +1;
                        
                    }
                    
                }
                totdependentes = (double)contt / nome.length * 100; 
                System.out.println("O totsl de dependentes é: "+contt+", e a porcentagem total é: "+totdependentes);
                    break;
                
            
            case 3: 
                System.out.println("Comando encerrado");
            break;
            default:
                System.out.println("Opcao invalida");
            }
            
        }while(valor != 3);
        
    
            }
        }
            
        
        
        
    

    

