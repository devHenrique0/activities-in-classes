package provafuncao;

import java.util.Scanner;

public class Provafuncao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double nota1, nota2, nota3, med;
        
        String media;

        

            System.out.println("Digite a primeira nota");
            nota1 = scanner.nextDouble();

            System.out.println("Digite a segunda nota");
            nota2 = scanner.nextDouble();
                    
            System.out.println("Digite a terceira nota");
            nota3 = scanner.nextDouble();
            
            System.out.println("Digite a forma que irá calcular a media");
            media = scanner.next();
            
            med = calcular(nota1, nota2, nota3, media);
            
        
    }

    static double calcular(double not1,double not2,double not3, String mediaa){
        double total =0;
        if(mediaa.equals("A")){
         total = (not1 + not2 + not3) / 3;
        }
        
        if (mediaa.equals("X")){
            if (not1 < not2 && not1 <not3){
                total = (not2 + not3) / 2;
            }
            else if(not2 < not1 && not2 < not3){
                total = (not1 + not3) / 2;
            }
            else if(not3 < not1 && not3 < not2){
                total = (not1 + not2) /2;
            }
        }
        System.out.println("MEDIA:  "+ total);
        return total;
    }
    
}