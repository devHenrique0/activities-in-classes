//Classe Teste

package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

// Classe auxiliar para carregar dados de funcionários
public class teste {

    // Método para carregar funcionários a partir do arquivo
    public static void carregarFuncionario(List<Funcionario> funcionarios) {
        try (BufferedReader reader = new BufferedReader(new FileReader("funcionarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Corrigido: separador correto entre nome e cargo
                String[] partes = linha.split(" Cargo: ");
                if (partes.length == 2) {
                    String nome = partes[0];
                    String cargo = partes[1];

                    if (!existeFuncionario(funcionarios, nome)) {
                        Funcionario novoFuncionario = new Funcionario(nome, cargo);
                        funcionarios.add(novoFuncionario);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de funcionários: " + e.getMessage());
        }
    }

    // Método auxiliar para verificar se um funcionário já existe na lista
    private static boolean existeFuncionario(List<Funcionario> funcionarios, String nome) {
        return funcionarios.stream().anyMatch(f -> f.getNome().equalsIgnoreCase(nome));
    }
}
