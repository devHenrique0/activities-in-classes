//Classe Principal_pedido

package menus.pedido;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import classes.Cliente;
import classes.Entrada;
import classes.Pedido;
import classes.Prato_principal;
import classes.Sobremesa;
import menus.cardapio.Cardapio;
import principal.index;

/**
 * Esta classe representa o menu de pedidos do restaurante.
 */
public class Principal_pedido {

    // Listas de clientes, pedidos, pratos principais, sobremesas e entradas
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Prato_principal> principais = Cardapio.getPrincipais();
    private static List<Sobremesa> sobremesas = Cardapio.getSobremesas();
    private static List<Entrada> entradas = Cardapio.getEntradas();

    /**
     * Método que exibe o menu de pedidos e permite a interação do usuário.
     */
    public static void PedidoMenu() {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Pedidos ===\n" +
                    "[1] Adicionar pedido\n" +
                    "[2] Remover pedido\n" +
                    "[3] Listar pedidos\n" +
                    "[4] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Se o usuário clicar Cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Pedido.adicionarPedido(clientes, pedidos, entradas, principais, sobremesas);
                        break;
                    case 2:
                        Pedido.RemovePedido(pedidos);
                        break;
                    case 3:
                        Pedido.ListarPedido(pedidos);
                        break;
                    case 4:
                        index.executarSistema();
                        return;
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