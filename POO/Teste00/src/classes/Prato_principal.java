//Classe Prato_principal

package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

// Classe representando os pratos principais no restaurante
public class Prato_principal {
    private String nome;
    private Double preco;

    // Construtores
    public Prato_principal() { }

    public Prato_principal(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Exibe o prato principal formatado
    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$ " + String.format("%.2f", preco);
    }

    // Método para criar um novo prato principal
    public static void CriaPrato_principal(List<Prato_principal> pratosPrincipais) {
        try {
            String nome = JOptionPane.showInputDialog(null, "Informe o nome do prato principal:");
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido.");
                return;
            }

            String precoStr = JOptionPane.showInputDialog(null, "Informe o preço:");
            if (precoStr == null || precoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preço inválido.");
                return;
            }

            Double preco = Double.parseDouble(precoStr);

            Prato_principal novoPrato = new Prato_principal(nome, preco);
            pratosPrincipais.add(novoPrato);

            JOptionPane.showMessageDialog(null, "Prato principal adicionado com sucesso!");

            String dados = nome + ", Preço: " + preco;
            FileManager.salvarDados(dados, "principais.txt");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido! Informe um número.");
        }
    }

    // Método para remover um prato principal
    public static void RemovePrato_principal(List<Prato_principal> pratosPrincipais) {
        String exclui = JOptionPane.showInputDialog(null, "Informe o nome do prato principal que deseja excluir:");
        if (exclui == null || exclui.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        boolean exist = false;
        Iterator<Prato_principal> iterator = pratosPrincipais.iterator();
        while (iterator.hasNext()) {
            Prato_principal prato = iterator.next();
            if (prato.getNome().equalsIgnoreCase(exclui)) {
                iterator.remove();
                exist = true;
                break;
            }
        }

        if (!exist) {
            JOptionPane.showMessageDialog(null,
                "Prato principal '" + exclui + "' não encontrado (verifique letras maiúsculas e minúsculas).");
        } else {
            JOptionPane.showMessageDialog(null, "Prato principal excluído com sucesso!");
            salvarPratosPrincipais(pratosPrincipais);
        }
    }

    // Método para salvar os pratos principais atualizados no arquivo
    private static void salvarPratosPrincipais(List<Prato_principal> pratosPrincipais) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("principais.txt"))) {
            for (Prato_principal principal : pratosPrincipais) {
                String dados = principal.getNome() + ", Preço: " + principal.getPreco();
                writer.write(dados);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os pratos principais: " + e.getMessage());
        }
    }

    // Método para listar todos os pratos principais
    public static void ListaPrato_principal(List<Prato_principal> pratosPrincipais) {
        if (!pratosPrincipais.isEmpty()) {
            Collections.sort(pratosPrincipais, (p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
            StringBuilder lista = new StringBuilder("___________ PRATOS PRINCIPAIS ___________\n");
            for (Prato_principal prato : pratosPrincipais) {
                lista.append(prato.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Cardápio de pratos principais está vazio!");
        }
    }
}