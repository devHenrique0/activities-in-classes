
package exerc1;
import java.util.Scanner;
public class Exerc1 {
public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //calcSal();
        
        //System.out.println("Salario liquido: "+ calcSal2());
        
        //System.out.println("Digite o salario bruto");
        //double salBrutomain = scan.nextDouble();
        //calcSal3(salBrutomain);
        
        //System.out.println("Digite o salario Bruto");
        //double salBruto = scan.nextDouble();
        //System.out.println("Salario liquido: "+ calcSal4(salBruto));
        
    }
    
    public static void calcSal (){
        System.out.println("Digite o salario bruto");
        double salBruto = scan.nextDouble();
        
        double inss = salBruto * 0.08;
        double ir = salBruto * 0.05;
        double salLiq = salBruto - inss - ir;
        
        System.out.println("Seu salario liquido é: "+salLiq);
        
    }
    
    public static double calcSal2(){
        System.out.println("Digite o salario bruto");
        double salBruto = scan.nextDouble();
        
        double inss = salBruto * 0.08;
        double ir = salBruto * 0.05;
        double salLiq = salBruto - inss - ir;
        
        return salLiq;
    }
    
    public static void calcSal3(double salBruto){
        double inss = salBruto * 0.08;
        double ir = salBruto * 0.05;
        double salLiq = salBruto - inss - ir;
        System.out.println("Seu salario liquido é: "+salLiq);
    }
    
    public static double calcSal4(double salBruto){
        double inss = salBruto * 0.08;
        double ir = salBruto * 0.05;
        double salLiq = salBruto - inss - ir;
        return salLiq;
    }
}
