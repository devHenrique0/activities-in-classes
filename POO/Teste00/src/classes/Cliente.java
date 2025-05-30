//Classe Cliente

package classes;

// Classe Cliente representa um cliente do restaurante
public class Cliente implements Comparable<Cliente> {
    private String nome;

    // Construtor vazio
    public Cliente() { }

    // Construtor com parâmetro
    public Cliente(String nome) {
        this.nome = nome;
    }

    // Getter para o nome do cliente
    public String getNome() {
        return nome;
    }

    // Setter para o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método compareTo para comparar clientes com base em seus nomes
    @Override
    public int compareTo(Cliente outroCliente) {
        if (outroCliente == null || outroCliente.getNome() == null) {
            return 1; // Clientes válidos vêm primeiro
        }
        return this.nome.compareToIgnoreCase(outroCliente.getNome());
    }

    // Método toString para exibir informações do cliente
    @Override
    public String toString() {
        return "Cliente: " + nome;
    }
}