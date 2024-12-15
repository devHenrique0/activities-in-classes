
package provaregistro;
import java.util.Scanner;

public class ProvaRegistro {

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        DadosAlunos[] alu = new DadosAlunos[1];
        
        int ind = 0; 
        double valorfinal;
        for (int i = 0; i < 1; i++) {
            alu[i] = new DadosAlunos();
            
            System.out.println("Digite o nome:");
            alu[i].nome = scanner.next();
            
            System.out.println("Digite o telefone:");
            alu[i].telefone = scanner.next();
            
            System.out.println("Digite o curso:");
            alu[i].curso = scanner.next();
            
            System.out.println("Digite o preco do curso sem desconto:");
            alu[i].precocurso = scanner.nextDouble();
            
            
            scanner.nextLine();
            ind ++;
            
        }
        System.out.printf("%10s %10s %10s %10s\n", "Nome", "Telefone", "Curso", "Preco Curso" );
        for (int i = 0; i < ind; i++) {
            System.out.printf("%10s %10s %10s %10.2f\n", alu[i].nome, alu[i].telefone, alu[i].curso,
                               alu[i].precocurso );
            
        }
       double total = 0, totals = 0;
        for (int i = 0; i < ind; i++) {
            if(alu[i].curso.equals("Piano")){
                total = (alu[i].precocurso * 10) / 100;
                totals = alu[i].precocurso - total  ;
                System.out.println("Valor final: "+ totals);
            }
            else if(alu[i].curso.equals("Teclado")){
                total = (alu[i].precocurso * 8) / 100;
                totals = alu[i].precocurso - total  ;
                System.out.println("Valor final: "+ totals);
            }
            else if(alu[i].curso.equals("Violao")){
                total = (alu[i].precocurso * 7) / 100;
                totals = alu[i].precocurso - total  ;
                System.out.println("Valor final: "+ totals);
            }
            else if(alu[i].curso.equals("Saxofone")){
                total = (alu[i].precocurso * 5) / 100;
                totals = alu[i].precocurso - total  ;
                System.out.println("Valor final: "+ totals);
            }
            else if(alu[i].curso.equals("Outros")){
                total = (alu[i].precocurso * 5) / 100;
                totals = alu[i].precocurso - total ;
                System.out.println("Valor final: "+ totals);
            }
            
        }
    }
    
   
    
    
    
}
