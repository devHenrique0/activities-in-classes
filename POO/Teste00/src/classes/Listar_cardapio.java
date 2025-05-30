//Classe Listar_cardapio

package classes;

import java.util.List;
import javax.swing.JOptionPane;

import menus.cardapio.Cardapio;

// Classe responsável por listar o cardápio do restaurante
public class Listar_cardapio {

    // Método para exibir o menu de listagem do cardápio
    public static void MenuListagem(List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas) {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Listagem do Cardápio ===\n" +
                    "[1] Listar entradas\n" +
                    "[2] Listar pratos principais\n" +
                    "[3] Listar sobremesas\n" +
                    "[4] Listar tudo\n" +
                    "[5] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Se o usuário clicar em Cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Entrada.ListarEntrada(entradas);
                        break;
                    case 2:
                        Prato_principal.ListaPrato_principal(principais);
                        break;
                    case 3:
                        Sobremesa.ListarSobremesa(sobremesas);
                        break;
                    case 4:
                        // Listar tudo
                        Entrada.ListarEntrada(entradas);
                        Prato_principal.ListaPrato_principal(principais);
                        Sobremesa.ListarSobremesa(sobremesas);
                        break;
                    case 5:
                        // Voltar ao menu anterior
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (opcao != 5);
    }
}