//Classe Principal_sobremesa

package menus.cardapio;

import java.util.List;
import javax.swing.JOptionPane;

import classes.Sobremesa;

// Classe para editar as sobremesas do cardápio
public class Principal_sobremesa {

    // Método para editar as sobremesas do cardápio
    public static void EditarSobremesa(List<Sobremesa> sobremesas) {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Sobremesas ===\n" +
                    "[1] Adicionar sobremesa\n" +
                    "[2] Remover sobremesa\n" +
                    "[3] Listar sobremesas\n" +
                    "[4] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Se o usuário clicar Cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Sobremesa.Cria_Sobremesa(sobremesas);
                        break;
                    case 2:
                        Sobremesa.RemoveSobremesa(sobremesas);
                        break;
                    case 3:
                        Sobremesa.ListarSobremesa(sobremesas);
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