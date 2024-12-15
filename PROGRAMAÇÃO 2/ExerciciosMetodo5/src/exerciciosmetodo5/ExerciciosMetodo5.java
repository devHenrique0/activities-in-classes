
package exerciciosmetodo5;
import java.util.Scanner;
public class ExerciciosMetodo5 {
public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Digite o peso inicial");
        double pesoInicial = scan.nextDouble();
        System.out.println("Digite o peso Atual");
        double pesoAtual = scan.nextDouble();
        
        double perc = calcpeso(pesoInicial, pesoAtual);
        
        if(perc > 0){
            System.out.println("Engordou"+ perc + "%");
        }else{
            System.out.println("Emagreceu"+ Math.abs(perc)+"%");
        }
        
        
        
    }
    public static double calcpeso(double pesoI, double pesoA){
        
        return (((pesoA - pesoI)/ pesoI) * 100);
    }
    
}
