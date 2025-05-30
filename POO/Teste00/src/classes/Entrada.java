//Classe Entrada

package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

// Classe Entrada
public class Entrada {

    private String nome;
    private Double preco;

    // Construtor vazio
    public Entrada() { }

    // Construtor com parâmetros
    public Entrada(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos getters e setters
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

    // Método para exibir a representação textual de uma entrada
    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + String.format("%.2f", preco);
    }

    // Método para criar uma nova entrada
    public static void Cria_entrada(List<Entrada> entradas) {
        try {
            String nome = JOptionPane.showInputDialog(null, "Informe o nome da entrada:");
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido.");
                return;
            }

            String precoStr = JOptionPane.showInputDialog(null, "Informe o preço da entrada:");
            if (precoStr == null || precoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preço inválido.");
                return;
            }

            Double preco = Double.parseDouble(precoStr);

            Entrada novaEntrada = new Entrada(nome, preco);
            entradas.add(novaEntrada);

            JOptionPane.showMessageDialog(null, "Entrada adicionada com sucesso!");

            // Salva no arquivo
            String dados = nome + ", Preço: " + preco;
            FileManager.salvarDados(dados, "entradas.txt");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido! Informe um número.");
        }
    }

    // Método para remover uma entrada
    public static void RemoveEntrada(List<Entrada> entradas) {
        String exclui = JOptionPane.showInputDialog(null, "Informe o nome da entrada que deseja excluir:");
        if (exclui == null || exclui.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        boolean exist = false;
        Iterator<Entrada> iterator = entradas.iterator();
        while (iterator.hasNext()) {
            Entrada entrada = iterator.next();
            if (entrada.getNome().equalsIgnoreCase(exclui)) {
                iterator.remove();
                exist = true;
                break;
            }
        }

        if (!exist) {
            JOptionPane.showMessageDialog(null,
                "Entrada '" + exclui + "' não encontrada (verifique letras maiúsculas e minúsculas).");
        } else {
            JOptionPane.showMessageDialog(null, "Entrada excluída com sucesso!");
            salvarEntradas(entradas);
        }
    }

    // Método auxiliar para salvar as entradas no arquivo
    private static void salvarEntradas(List<Entrada> entradas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("entradas.txt"))) {
            for (Entrada entrada : entradas) {
                String dados = entrada.getNome() + ", Preço: " + entrada.getPreco();
                writer.write(dados);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados das entradas: " + e.getMessage());
        }
    }

    // Método para listar as entradas disponíveis
    public static void ListarEntrada(List<Entrada> entradas) {
        if (!entradas.isEmpty()) {
            Collections.sort(entradas, (e1, e2) -> e1.getNome().compareToIgnoreCase(e2.getNome()));
            StringBuilder lista = new StringBuilder("___________ ENTRADAS ___________\n");
            for (Entrada entrada : entradas) {
                lista.append(entrada.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Cardápio de entradas está vazio!");
        }
    }
}