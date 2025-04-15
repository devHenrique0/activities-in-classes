
package aula03;

import java.util.HashMap;
import java.util.Map;


public class Aula03 {

    
    public static void main(String[] args) {
        Map<Integer, String> mapNomes = new HashMap<Integer, String>();
        
        mapNomes.put(111, "Maria");
        mapNomes.put(222, "Henrique");
        
        System.out.println(mapNomes.get(111));
        System.out.println(mapNomes.remove(222));
        
        System.out.println(mapNomes.put(111, "JoaQueen"));
        
        System.out.println(mapNomes.get(111));
    }
    
}
