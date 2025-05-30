//Classe Funcionario

package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

// Classe Funcionario representa os funcionários do restaurante
public class Funcionario {
    // Atributos da classe
    private String nome;
    private String cargo;

    // Construtor vazio
    public Funcionario() { }

    // Construtor com parâmetros
    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para exibir a representação textual de um Funcionario
    @Override
    public String toString() {
        return "Nome: " + nome + ", Cargo: " + cargo;
    }

    // Método para cadastrar um novo funcionário
    public static void Cria_Funcionario(List<Funcionario> funcionarios) {
        String nome = JOptionPane.showInputDialog(null, "Informe o nome do funcionário:");
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        String cargo = JOptionPane.showInputDialog(null, "Informe o cargo do funcionário:");
        if (cargo == null || cargo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cargo inválido.");
            return;
        }

        Funcionario novoFuncionario = new Funcionario(nome, cargo);
        funcionarios.add(novoFuncionario);

        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso!");

        String dados = nome + " Cargo: " + cargo;
        FileManager.salvarDados(dados, "funcionarios.txt");
    }

    // Método para remover um funcionário
    public static void RemoveFuncionarios(List<Funcionario> funcionarios) {
        String exclui = JOptionPane.showInputDialog(null, "Informe o nome do funcionário que deseja excluir:");
        if (exclui == null || exclui.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        boolean exist = false;
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario funcionario = iterator.next();
            if (funcionario.getNome().equalsIgnoreCase(exclui)) {
                iterator.remove();
                exist = true;
                break;
            }
        }

        if (!exist) {
            JOptionPane.showMessageDialog(null,
                "Funcionário '" + exclui + "' não encontrado (verifique letras maiúsculas e minúsculas).");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
            salvarFuncionarios(funcionarios);
        }
    }

    // Método para listar os funcionários disponíveis
    public static void ListarFuncionario(List<Funcionario> funcionarios) {
        if (!funcionarios.isEmpty()) {
            Collections.sort(funcionarios, (f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()));
            StringBuilder lista = new StringBuilder("___________ FUNCIONÁRIOS ___________\n");
            for (Funcionario funcionario : funcionarios) {
                lista.append(funcionario.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Lista de funcionários está vazia!");
        }
    }

    // Método auxiliar para salvar os funcionários no arquivo
    private static void salvarFuncionarios(List<Funcionario> funcionarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("funcionarios.txt"))) {
            for (Funcionario funcionario : funcionarios) {
                String dados = funcionario.getNome() + " Cargo: " + funcionario.getCargo();
                writer.write(dados);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados dos funcionários: " + e.getMessage());
        }
    }
}