
package aula.pkg02;

import java.util.List;
import java.util.ArrayList;

public class Aula02 {

    
    public static void main(String[] args) {
        
        List<Integer> listaNumeros = new ArrayList<Integer>();
        
        List<String> listaCidades = new ArrayList<String>();
        
        listaNumeros.add(333);
        listaNumeros.add(444);
        listaNumeros.add(555);
        listaNumeros.add(666);
        
        listaCidades.add("Mococa");
        listaCidades.add("Rio de Janeiro");
        listaCidades.add("São Paulo");
        
        System.out.println("Números");
        
        for(int i = 0; i < listaNumeros.size(); i++){
        System.out.println(listaNumeros.get(i));
    }
        
        System.out.println("#####################");
        
        for(Integer valor : listaNumeros){
            System.out.println(valor);
        }
        
        System.out.println("Cidades");
        
        for (int i = 0; i < listaCidades.size(); i++) {
            System.out.println(listaCidades.get(i));
        }
        
        System.out.println("#####################");
        
        for (String cidade : listaCidades) {
            System.out.println(cidade);
        }
        
        System.out.println("######################");
        
        listaCidades.forEach(cidade -> {
            System.out.println(cidade); 
        });
                
        
    }
    
}
