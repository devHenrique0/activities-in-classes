
package algoritmoprincipal;
import java.util.Scanner;

public class AlgoritmoPrincipal {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int COD, NHA, I;
        String SEXO;
        double SL;

        for (I = 1; I <= 10; I++) {
            System.out.println("Digite o CODIGO:");
            COD = scanner.nextInt();
            
            System.out.println("Digite o SEXO:");
            SEXO = scanner.next();
            
            System.out.println("Digite o Nº DE HORAS AULAS:");
            NHA = scanner.nextInt();
            
            SL = calcular(SEXO, NHA);
            verifica(SL);
        }
    }

    static double calcular(String S, int N) {
        int I;
        double SB, SALL, DESC;
        
        SB = N * 12.50;
        System.out.println("SALÁRIO BRUTO = " + SB);

        if (S.equals("F")) {
            if (N <= 70) {
                DESC = SB * 7 / 100;
            } else {
                DESC = SB * 5 / 100;
            }
        } else if (S.equals("M")) {
            if (N <= 70) {
                SB = SB * 10 / 100;
            } else {
                SB = SB * 8 / 100;
            }
            DESC = 0;
        } else {
            DESC = 0;
        }

        System.out.println("DESCONTO = " + DESC);
        SALL = SB - DESC;
        System.out.println("SALARIO LIQUIDO = " + SALL);
        return SALL;
    }

    static void verifica(double S) {
        if (S >= 1000) {
            System.out.println("BEM REMUNERADO");
        } else {
            System.out.println("MAL REMUNERADO");
        }
    }
}

    
