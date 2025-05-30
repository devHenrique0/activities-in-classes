//Classe Principal_entrada

package menus.cardapio;

import java.util.List;
import javax.swing.JOptionPane;

import classes.Entrada;

// Classe para editar as entradas do cardápio
public class Principal_entrada {

    // Método para editar as entradas do cardápio
    public static void EditarEntrada(List<Entrada> entradas) {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Edição de Entradas ===\n" +
                    "[1] Adicionar entrada\n" +
                    "[2] Remover entrada\n" +
                    "[3] Listar entradas\n" +
                    "[4] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Se o usuário cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Entrada.Cria_entrada(entradas);
                        break;
                    case 2:
                        Entrada.RemoveEntrada(entradas);
                        break;
                    case 3:
                        Entrada.ListarEntrada(entradas);
                        break;
                    case 4:
                        return; // Voltar ao menu anterior
                    default:
                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (opcao != 4);
    }
}