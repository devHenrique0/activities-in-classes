//Classe Cardapio

package menus.cardapio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import classes.Busca;
import classes.Entrada;
import classes.Listar_cardapio;
import classes.Prato_principal;
import classes.Sobremesa;
import principal.index;

// Classe que define o menu do cardápio e suas funcionalidades
public class Cardapio {
    // Listas de itens do cardápio
    private static List<Entrada> entradas = new ArrayList<>();
    private static List<Prato_principal> principais = new ArrayList<>();
    private static List<Sobremesa> sobremesas = new ArrayList<>();

    // Métodos para retornar as listas de itens do cardápio
    public static List<Entrada> getEntradas() {
        return entradas;
    }

    public static List<Prato_principal> getPrincipais() {
        return principais;
    }

    public static List<Sobremesa> getSobremesas() {
        return sobremesas;
    }

    // Método para exibir o menu do cardápio
    public static void CardapioMenu() {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu do Cardápio ===\n" +
                    "[1] Entradas\n" +
                    "[2] Pratos principais\n" +
                    "[3] Sobremesas\n" +
                    "[4] Listar cardápio\n" +
                    "[5] Procurar item específico\n" +
                    "[6] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Usuário apertou "Cancelar"
                    break;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        // Edição das entradas do cardápio
                        Principal_entrada.EditarEntrada(entradas);
                        break;
                    case 2:
                        // Edição dos pratos principais do cardápio
                        Principal_prato_principal.EditarPrincipal(principais);
                        break;
                    case 3:
                        // Edição das sobremesas do cardápio
                        Principal_sobremesa.EditarSobremesa(sobremesas);
                        break;
                    case 4:
                        // Listagem completa do cardápio
                        Listar_cardapio.MenuListagem(entradas, principais, sobremesas);
                        break;
                    case 5:
                        // Busca por item específico
                        Busca.BuscarItem(entradas, principais, sobremesas);
                        break;
                    case 6:
                        // Retorno ao menu principal
                        index.executarSistema();
                        return; // Sai do método CardapioMenu
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (true);
    }
}