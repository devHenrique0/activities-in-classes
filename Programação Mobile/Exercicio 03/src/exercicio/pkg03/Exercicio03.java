
package exercicio.pkg03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class Exercicio03 {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Map<Integer, Integer> valores = new HashMap<Integer, Integer>();
        
        Integer numero = 0;
        
        while(numero != -1){
            System.out.println("Digite um valor: ");
            numero = scanner. nextInt();
            
            if(valores.get(numero) == null){
                valores.put(numero, 1);
            }else{
                Integer temp = valores.get(numero);
                temp++;
                valores.put(numero, temp);
            }
        }
        
        for (Entry<Integer, Integer> e : valores.entrySet()) {
            System.out.println(e.getKey() + "-->" + e.getValue());
        }
        
    }
    
}
