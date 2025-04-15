
package exercicio.pkg02;

import java.util.ArrayList;
import java.util.List;


public class Exercicio02 {

    
    public static void main(String[] args) {
        
        List<Integer> listaNumeros = new ArrayList<Integer>();
        List<Integer> listaImpares = new ArrayList<Integer>();

        Integer somaImpar = 0;

        
        for (int i = 0; i < 10; i++) {
            listaNumeros.add((int) (Math.random() *1000));
        }

        
        for (Integer valor : listaNumeros) {
            if(valor %2 != 0){
                listaImpares.add(valor);
                somaImpar += valor;

            }
        }
        
        listaImpares.forEach(impar ->{
            System.out.println(impar);
        });
        
        
        System.out.println("Soma Impares: " + somaImpar);
        System.out.println("Media" + (somaImpar / listaImpares.size()));
        System.out.println("Quantidade impares" + listaImpares.size());
    }
    
}
