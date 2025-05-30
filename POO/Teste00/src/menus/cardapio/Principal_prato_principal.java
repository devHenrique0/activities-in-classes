//Classe Principal_prato_principal

package menus.cardapio;

import java.util.List;
import javax.swing.JOptionPane;

import classes.Prato_principal;

// Classe para editar os pratos principais do cardápio
public class Principal_prato_principal {

    // Método para editar os pratos principais do cardápio
    public static void EditarPrincipal(List<Prato_principal> principais) {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Pratos Principais ===\n" +
                    "[1] Adicionar prato principal\n" +
                    "[2] Remover prato principal\n" +
                    "[3] Listar pratos principais\n" +
                    "[4] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Se o usuário clicar Cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Prato_principal.CriaPrato_principal(principais);
                        break;
                    case 2:
                        Prato_principal.RemovePrato_principal(principais);
                        break;
                    case 3:
                        Prato_principal.ListaPrato_principal(principais);
                        break;
                    case 4:
                        return; // Voltar ao menu anterior (Cardápio)
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