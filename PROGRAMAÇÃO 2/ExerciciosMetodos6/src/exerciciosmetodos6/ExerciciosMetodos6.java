
package exerciciosmetodos6;
import java.util.Scanner;
public class ExerciciosMetodos6 {
public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Digite um numero");
        int numDig = scan.nextInt();
        //chamando o primeiro metodo
        
        //int resto = Epar(numDig);
        //passando o valor do metodo para uma variavel
        
        //ou já colocar desse jeito 
        if(Epar(numDig) == 0){
            System.out.println("E par");
        }else{
            System.out.println("E impar");
        }
        
        if(EparChar(numDig) == 'P'){
            System.out.println("E par");
        }else{
            System.out.println("E impar");
        }
        
        System.out.println(""+EparString(numDig));
        
        if (eParBoolean(numDig)){
            System.out.println("E par");
        }else{
            System.out.println("E impar");
        }
    }
    public static int Epar (int n){
        return n%2;
    }
    public static char EparChar(int n ){
        if(n%2 == 0){
            return 'P';
        }else
            return 'I';
    }
    public static String EparString (int n){
        if(n%2 == 0){
            return "P";
        }else
            return "I";
    }
    public static boolean eParBoolean(int n){
        return n%2 == 0;
    }
    
}
