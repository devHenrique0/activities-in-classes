//Classe index

package principal;

import java.util.List;
import javax.swing.JOptionPane;

import classes.GuiLogin;
import classes.Entrada;
import classes.Prato_principal;
import classes.Sobremesa;
import classes.Funcionario;
import classes.FileManager;

import menus.cardapio.Cardapio;
import menus.funcionario.PrincipalFuncionario;
import menus.pedido.Principal_pedido;

// Classe principal do sistema
public class index {

    // Listas do cardápio e funcionários
    private static List<Entrada> entradas = Cardapio.getEntradas();
    private static List<Prato_principal> principais = Cardapio.getPrincipais();
    private static List<Sobremesa> sobremesas = Cardapio.getSobremesas();
    private static List<Funcionario> funcionarios = PrincipalFuncionario.getFuncionarios();

    // Método principal
    public static void main(String[] args) {
        // Carrega os dados dos arquivos
        FileManager.carregarEntradas(entradas);
        FileManager.carregarPratosPrincipais(principais);
        FileManager.carregarSobremesas(sobremesas);
        FileManager.carregarFuncionarios(funcionarios);

        // Exibe a tela de login
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GuiLogin().setVisible(true);
        });
    }

    // Método para exibir o menu principal do sistema após login
    public static void executarSistema() {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu Principal ===\n" +
                    "[1] Acessar cardápio\n" +
                    "[2] Acessar pedidos\n" +
                    "[3] Acessar funcionários\n" +
                    "[4] Sair\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Usuário clicou em cancelar
                    break;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Cardapio.CardapioMenu();
                        break;
                    case 2:
                        Principal_pedido.PedidoMenu();
                        break;
                    case 3:
                        PrincipalFuncionario.FuncionarioMenu();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha uma opção válida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (opcao != 4);
    }
}