//Classe Busca

package classes;

import java.util.List;
import javax.swing.JOptionPane;

public class Busca {
    // Método para buscar um item nos menus de entradas, pratos principais e sobremesas
    public static void BuscarItem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas){
        String itemBuscado = JOptionPane.showInputDialog(null, "Insira o nome do item que deseja buscar:");
        
        if (itemBuscado == null || itemBuscado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item informado.");
            return;
        }

        boolean encontrado = false;

        // Verifica se o item está presente no menu de entradas
        for (Entrada entrada : entradas) {
            if (entrada.getNome().equalsIgnoreCase(itemBuscado)) {
                JOptionPane.showMessageDialog(null, 
                    "Item encontrado!\n" + itemBuscado + " se encontra no menu de entradas.");
                encontrado = true;
                break;
            }
        }

        // Verifica se o item está presente no menu de pratos principais
        if (!encontrado) {
            for (Prato_principal principal : principais) {
                if (principal.getNome().equalsIgnoreCase(itemBuscado)) {
                    JOptionPane.showMessageDialog(null, 
                        "Item encontrado!\n" + itemBuscado + " se encontra no menu de pratos principais.");
                    encontrado = true;
                    break;
                }
            }
        }

        // Verifica se o item está presente no menu de sobremesas
        if (!encontrado) {
            for (Sobremesa sobremesa : sobremesas) {
                if (sobremesa.getNome().equalsIgnoreCase(itemBuscado)) {
                    JOptionPane.showMessageDialog(null, 
                        "Item encontrado!\n" + itemBuscado + " se encontra no menu de sobremesas.");
                    encontrado = true;
                    break;
                }
            }
        }

        // Caso o item não seja encontrado em nenhum dos menus
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, 
                "Item '" + itemBuscado + "' não encontrado em nenhum dos menus.\n(Verifique letras maiúsculas e minúsculas)");
        }
    }
}