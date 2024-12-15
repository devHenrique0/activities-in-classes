
package aula2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aula2024 {

    
    public static void main(String[] args) throws FileNotFoundException {
    
       File arq = new File("dados"); 
       Scanner scan = new Scanner(arq);
       
       char tipo;
       double aluguel;
       int status;
       String nome;
       
        System.out.printf("%10s %10s %10s %10s \n", scan.next(), scan.next(), scan.next(), scan.next());
       
       
        for (int i = 0; i < 3; i++) {
           tipo = scan.next().charAt(0);
           aluguel = scan.nextDouble();
           status = scan.nextInt();
           nome = scan.next(); 
        
           System.out.printf("%10c %10.2f %10d %10s \n", tipo, aluguel, status, nome);
        }
        
    }
    
}
