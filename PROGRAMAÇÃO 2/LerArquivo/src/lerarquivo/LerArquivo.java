
package lerarquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LerArquivo {


    public static void main(String[] args) throws FileNotFoundException {
        File fil = new File ("dados");
        Scanner scan = new Scanner(fil);
        Venda ven[] = new Venda[4];
        
        System.out.printf("%10s %10s %10s %10s \n", scan.next(), scan.next(), scan.next(), scan.next());
        
        for (int i = 0; i < ven.length; i++) {
            //ven[i] = new Venda();
            ven[i] = new Venda(scan.next(), scan.next(), scan.nextDouble(), scan.nextInt() );
  
          //  ven[i].cliente = scan.next();
          //  ven[i].produto = scan.next();
          //  ven[i].precoUnit = scan.nextDouble();
          //  ven[i].qtd = scan.nextInt();
            
            System.out.printf("%10s %10s %10.2f %10d \n", ven[i].cliente, ven[i].produto, ven[i].precoUnit, ven[i].qtd);
        }
        
    }
    
}
