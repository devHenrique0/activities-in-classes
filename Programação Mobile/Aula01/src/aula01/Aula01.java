
package aula01;


public class Aula01 {

  
    public static void main(String[] args) {
        int valoresA[] = new int[10];
        int valoresB[] = new int[10]; 
        int valoresC[] = new int[10];
        int resultA = 0;
        int resultB = 0;
        int resultC = 0;
        
        for (int i = 0; i < 10; i++) {
            valoresA[i] = (int) (Math.random() *1000);
            valoresB[i] = (int) (Math.random() *1000);
            valoresC[i] = valoresA[i] + valoresB[i];
            
            resultA += valoresA[i];
            resultB += valoresB[i];
            resultC += valoresC[i];
            
            
//            
//            System.out.println(valoresA[i] + "  +   "+ valoresB[i]+"  =  "+ valoresC[i]);

        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n  %2d  %2d  %2d", valoresA[i], valoresB[i], valoresC[i]);
        }
        System.out.println("\n" + resultA + "   " + resultB + "  "+ resultC +" ");
        

    }
    
}
