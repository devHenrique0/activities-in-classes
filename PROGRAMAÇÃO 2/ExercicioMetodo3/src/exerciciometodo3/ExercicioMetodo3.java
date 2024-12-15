
package exerciciometodo3;
import java.util.Scanner;

public class ExercicioMetodo3 {
public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Digite o Salario Bruto");
        double salarioBruto = scan.nextDouble();
        
        double inss = calcInss(salarioBruto);
        double salSem = salarioBruto - inss;
        double salFinal = calcSalFinal(salSem);
        System.out.println("Salario FInal:"+ salFinal);
        
        // ou o de cima ou o debaixo, são a mesma coisa de jeitos diferentes
        
        System.out.println("Salario Final"+ calcSalFinal(salarioBruto - calcInss(salarioBruto)));
    }
    
    public static double calcInss (double salBruto){
        double inss = salBruto * 0.08;
        return inss;
    }
            
    public static double calcSalFinal(double salSemInss){
        double ir = salSemInss * 0.05;
        return salSemInss - ir;
    }
    
}
