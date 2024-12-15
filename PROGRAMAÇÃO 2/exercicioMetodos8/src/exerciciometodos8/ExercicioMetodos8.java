
package exerciciometodos8;
import java.util.Scanner;

public class ExercicioMetodos8 {
public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        //VOID COM PARAMETROS
       int idade1[] = new int [5];
//       lerDados1(idade1);
       
       //NÃO VOID SEM PARAMETROS
       int idade2[] = lerDados2();
       
       //NÃO VOID COM PARAMETROS
       //int idade3[] = new int[5];
        //System.out.println("Media"+ calcMedia(idade3));
        
        //VOID COM PARAMETRO
//        CalcMaior(idade1);
        
        for (int i = 0; i < 5; i++) {
            System.out.println(idade2[i] + " ");
        }
        
        //VOID SEM PARAMETRO
        encerrar();
    }
    
    public static void lerDados1(int id[]){
        System.out.println("Digite as idades");
        for (int i = 0; i < id.length; i++) {
            System.out.println("idade["+ (i+1)+ "]");
            id[i] = scan.nextInt();
        }
    }
    public static int [] lerDados2(){
        int id2[] = new int[5];
        System.out.println("Digite as idades");
        for (int i = 0; i < id2.length; i++) {
            System.out.println("idade["+ (i+1)+ "]");
            id2[i] = scan.nextInt();
        }
        return id2;
    }
    public static double calcMedia(int id3 []){
        double soma = 0;
        for (int i = 0; i < id3.length; i++) {
            soma += id3[i];
        }
        return soma / id3.length;
    }
    public static void CalcMaior (int id4[]){
        double maior = id4[0];
        for (int i = 0; i < id4.length; i++) {
            if(id4[i]> maior){
                maior = id4[i];
            }
        }
        System.out.println("Maior"+ maior);
    }
    public static void encerrar(){
        System.out.println("Sistema fechado");
    }
}
