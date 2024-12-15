
package exerciciometodos7;
import java.util.Scanner;


public class ExercicioMetodos7 {
public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int idade[] = new int[5];
        
        for (int i = 0; i < idade.length; i++) {
            System.out.println("Digite a sua idade");
            int id = scan.nextInt();
            idade[i] = id;
        }
        System.out.println("A media e "+ IdadeCalc(idade));
    }
    
    public static int IdadeCalc (int idade[]){
        int soma = 0;
        for (int i = 0; i < idade.length; i++) {
            soma += idade[i];
        }
        int calcmedia = soma/5;
        return calcmedia;
    }
    
}
