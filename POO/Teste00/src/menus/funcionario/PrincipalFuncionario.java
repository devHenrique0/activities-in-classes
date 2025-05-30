//Classe PrincipalFuncionario

package menus.funcionario;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import classes.Funcionario;
import principal.index;

public class PrincipalFuncionario {

    private static List<Funcionario> funcionarios = new ArrayList<>();

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void FuncionarioMenu() {
        int opcao = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                    "=== Menu de Funcionários ===\n" +
                    "[1] Cadastrar funcionário\n" +
                    "[2] Remover funcionário\n" +
                    "[3] Listar funcionários\n" +
                    "[4] Voltar\n\n" +
                    "Digite a opção:"
                );

                if (input == null) { // Usuário clicou em Cancelar
                    return;
                }

                opcao = Integer.parseInt(input);

                switch (opcao) {
                    case 1:
                        Funcionario.Cria_Funcionario(funcionarios);
                        break;
                    case 2:
                        Funcionario.RemoveFuncionarios(funcionarios);
                        break;
                    case 3:
                        Funcionario.ListarFuncionario(funcionarios);
                        break;
                    case 4:
                        index.executarSistema();
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Informe uma opção válida!");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido!");
            }
        } while (true);
    }
}