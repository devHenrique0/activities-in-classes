
package lojaCompraVenda;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class lojaCompraVenda {

    
    public static void main(String[] args) {
      
        File arq = new File ("dados");
        Estoque est [] = new Estoque [5];
        
        try {
            //chamada do metodo lerDados()
            lerDados(est);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não escontrado");
        }
    }
   
    public static void lerDados(Estoque est[]) throws FileNotFoundException{
        File arq = new File ("dados");
        Scanner scan = new Scanner(arq);
        
        System.out.printf("%10s %10s %10s %10s \n", scan.next(), scan.next(), scan.next(), scan.next());
            
            for (int i = 0; i < est.length; i++) {
                est[i] = new Estoque(scan.nextInt(), scan.next(), scan.nextInt(), scan.nextDouble());
                
                System.out.printf("%10d %10s %10d %10.2f \n", est[i].codigo, est[i].descricao, est[i].estoque, est[i].precoCompra);
            }
            
    }
}
