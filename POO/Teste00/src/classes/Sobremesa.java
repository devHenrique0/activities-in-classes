//Classe Sobremesa

package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

// Classe representando as sobremesas no restaurante
public class Sobremesa {
    private String nome;
    private Double preco;

    // Construtores
    public Sobremesa() { }

    public Sobremesa(String nome, Double preco) {
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

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$ " + String.format("%.2f", preco);
    }

    // Método para criar uma nova sobremesa e adicioná-la à lista
    public static void Cria_Sobremesa(List<Sobremesa> sobremesas) {
        try {
            String nome = JOptionPane.showInputDialog(null, "Informe o nome da sobremesa:");
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

            Sobremesa novaSobremesa = new Sobremesa(nome, preco);
            sobremesas.add(novaSobremesa);

            JOptionPane.showMessageDialog(null, "Sobremesa adicionada com sucesso!");

            String dados = nome + ", Preço: " + preco;
            FileManager.salvarDados(dados, "sobremesas.txt");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido! Informe um número válido.");
        }
    }

    // Método para remover uma sobremesa da lista
    public static void RemoveSobremesa(List<Sobremesa> sobremesas) {
        String exclui = JOptionPane.showInputDialog(null, "Informe o nome da sobremesa que deseja excluir:");
        if (exclui == null || exclui.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        boolean exist = false;
        Iterator<Sobremesa> iterator = sobremesas.iterator();
        while (iterator.hasNext()) {
            Sobremesa sobremesa = iterator.next();
            if (sobremesa.getNome().equalsIgnoreCase(exclui)) {
                iterator.remove();
                exist = true;
                break;
            }
        }

        if (!exist) {
            JOptionPane.showMessageDialog(null,
                "Sobremesa '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas).");
        } else {
            JOptionPane.showMessageDialog(null, "Sobremesa excluída com sucesso!");
            salvarSobremesas(sobremesas);
        }
    }

    // Método para salvar as sobremesas atualizadas no arquivo
    private static void salvarSobremesas(List<Sobremesa> sobremesas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sobremesas.txt"))) {
            for (Sobremesa sobremesa : sobremesas) {
                String dados = sobremesa.getNome() + ", Preço: " + sobremesa.getPreco();
                writer.write(dados);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados das sobremesas: " + e.getMessage());
        }
    }

    // Método para listar todas as sobremesas
    public static void ListarSobremesa(List<Sobremesa> sobremesas) {
        if (!sobremesas.isEmpty()) {
            Collections.sort(sobremesas, (s1, s2) -> s1.getNome().compareToIgnoreCase(s2.getNome()));
            StringBuilder lista = new StringBuilder("___________ SOBREMESAS ___________\n");
            for (Sobremesa sobremesa : sobremesas) {
                lista.append(sobremesa.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "O cardápio de sobremesas está vazio!");
        }
    }
}