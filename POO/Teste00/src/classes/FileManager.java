//Classe FileManager

package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Classe responsável por operações de gerenciamento de arquivos
public class FileManager {

    // Método para salvar os dados em um arquivo de texto
    public static void salvarDados(String dados, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write(dados);
            writer.newLine(); // Adiciona uma nova linha após cada conjunto de dados
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    // Carrega as entradas do arquivo entradas.txt
    public static void carregarEntradas(List<Entrada> entradas) {
        carregarGenerico("entradas.txt", entradas, "Entrada");
    }

    // Carrega os pratos principais do arquivo principais.txt
    public static void carregarPratosPrincipais(List<Prato_principal> principais) {
        carregarGenerico("principais.txt", principais, "PratoPrincipal");
    }

    // Carrega as sobremesas do arquivo sobremesas.txt
    public static void carregarSobremesas(List<Sobremesa> sobremesas) {
        carregarGenerico("sobremesas.txt", sobremesas, "Sobremesa");
    }

    // Carrega os funcionários do arquivo funcionarios.txt
    public static void carregarFuncionarios(List<Funcionario> funcionarios) {
        try (BufferedReader reader = new BufferedReader(new FileReader("funcionarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" Cargo: ");
                if (partes.length == 2) {
                    String nome = partes[0];
                    String cargo = partes[1];
                    if (!existeFuncionario(funcionarios, nome)) {
                        Funcionario funcionario = new Funcionario(nome, cargo);
                        funcionarios.add(funcionario);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de funcionários: " + e.getMessage());
        }
    }

    // Métodos auxiliares

    private static void carregarGenerico(String arquivo, List<?> lista, String tipo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(", Preço: ");
                if (partes.length == 2) {
                    String nome = partes[0];
                    Double preco = Double.parseDouble(partes[1]);

                    switch (tipo) {
                        case "Entrada":
                            if (!existeEntrada((List<Entrada>) lista, nome)) {
                                Entrada entrada = new Entrada(nome, preco);
                                ((List<Entrada>) lista).add(entrada);
                            }
                            break;
                        case "PratoPrincipal":
                            if (!existePratoPrincipal((List<Prato_principal>) lista, nome)) {
                                Prato_principal principal = new Prato_principal(nome, preco);
                                ((List<Prato_principal>) lista).add(principal);
                            }
                            break;
                        case "Sobremesa":
                            if (!existeSobremesa((List<Sobremesa>) lista, nome)) {
                                Sobremesa sobremesa = new Sobremesa(nome, preco);
                                ((List<Sobremesa>) lista).add(sobremesa);
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + arquivo + ": " + e.getMessage());
        }
    }

    private static boolean existeEntrada(List<Entrada> entradas, String nome) {
        return entradas.stream().anyMatch(e -> e.getNome().equalsIgnoreCase(nome));
    }

    private static boolean existePratoPrincipal(List<Prato_principal> principais, String nome) {
        return principais.stream().anyMatch(p -> p.getNome().equalsIgnoreCase(nome));
    }

    private static boolean existeSobremesa(List<Sobremesa> sobremesas, String nome) {
        return sobremesas.stream().anyMatch(s -> s.getNome().equalsIgnoreCase(nome));
    }

    private static boolean existeFuncionario(List<Funcionario> funcionarios, String nome) {
        return funcionarios.stream().anyMatch(f -> f.getNome().equalsIgnoreCase(nome));
    }
}