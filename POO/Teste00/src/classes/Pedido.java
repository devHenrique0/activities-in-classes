//Classe Pedido

package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

import menus.pedido.Principal_pedido;

public class Pedido {
    // Atributos da classe Pedido
    private Cliente cliente;
    private Integer mesa;
    private List<Entrada> entrada;
    private List<Prato_principal> pratoPrincipal;
    private List<Sobremesa> sobremesa;
    private Double totalConta;

    // Construtores
    public Pedido() { }

    public Pedido(Cliente cliente, Integer mesa, List<Entrada> entrada, List<Prato_principal> pratoPrincipal, List<Sobremesa> sobremesa) {
        this(cliente, mesa, entrada, pratoPrincipal, sobremesa, null);
    }

    public Pedido(Cliente cliente, Integer mesa, List<Entrada> entrada, List<Prato_principal> pratoPrincipal, List<Sobremesa> sobremesa, Double totalConta) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.entrada = entrada;
        this.pratoPrincipal = pratoPrincipal;
        this.sobremesa = sobremesa;
        this.totalConta = totalConta;
    }

    public Pedido(Cliente cliente, Integer mesa, Entrada entrada, Prato_principal pratoPrincipal, Sobremesa sobremesa, Double totalConta) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.entrada = new ArrayList<>();
        this.entrada.add(entrada);
        this.pratoPrincipal = new ArrayList<>();
        this.pratoPrincipal.add(pratoPrincipal);
        this.sobremesa = new ArrayList<>();
        this.sobremesa.add(sobremesa);
        this.totalConta = totalConta;
    }

    // Getters e Setters
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Integer getMesa() { return mesa; }
    public void setMesa(Integer mesa) { this.mesa = mesa; }
    public List<Entrada> getEntrada() { return entrada; }
    public void setEntrada(List<Entrada> entrada) { this.entrada = entrada; }
    public List<Prato_principal> getPratoPrincipal() { return pratoPrincipal; }
    public void setPratoPrincipal(List<Prato_principal> pratoPrincipal) { this.pratoPrincipal = pratoPrincipal; }
    public List<Sobremesa> getSobremesa() { return sobremesa; }
    public void setSobremesa(List<Sobremesa> sobremesa) { this.sobremesa = sobremesa; }
    public Double getTotalConta() { return totalConta; }
    public void setTotalConta(Double totalConta) { this.totalConta = totalConta; }

    // Método para adicionar um novo pedido
    public static void adicionarPedido(List<Cliente> clientes, List<Pedido> pedidos, List<Entrada> entradas, List<Prato_principal> principais, List<Sobremesa> sobremesas) {
        try {
            String nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente:");
            if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido.");
                return;
            }
            Cliente cliente = new Cliente(nomeCliente);

            String mesaStr = JOptionPane.showInputDialog(null, "Informe o número da mesa:");
            Integer mesa = Integer.parseInt(mesaStr);

            Double valorTotal = 0.0;

            Entrada entradaSelecionada = selecionarEntrada(entradas);
            if (entradaSelecionada != null) {
                valorTotal += entradaSelecionada.getPreco();
            }

            Prato_principal principalSelecionado = selecionarPrincipal(principais);
            if (principalSelecionado != null) {
                valorTotal += principalSelecionado.getPreco();
            }

            Sobremesa sobremesaSelecionada = selecionarSobremesa(sobremesas);
            if (sobremesaSelecionada != null) {
                valorTotal += sobremesaSelecionada.getPreco();
            }

            // Exibe resumo do pedido
            String resumo = "_____________ PEDIDO _____________\n" +
                            "Nome: " + cliente.getNome() + "\n" +
                            "Mesa: " + mesa + "\n" +
                            "Entrada: " + (entradaSelecionada != null ? entradaSelecionada.getNome() : "Nenhuma") + "\n" +
                            "Prato Principal: " + (principalSelecionado != null ? principalSelecionado.getNome() : "Nenhum") + "\n" +
                            "Sobremesa: " + (sobremesaSelecionada != null ? sobremesaSelecionada.getNome() : "Nenhuma") + "\n" +
                            "Valor total: R$ " + String.format("%.2f", valorTotal);

            JOptionPane.showMessageDialog(null, resumo);

            pedidos.add(new Pedido(cliente, mesa, entradaSelecionada, principalSelecionado, sobremesaSelecionada, valorTotal));
            Principal_pedido.PedidoMenu();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido. Pedido cancelado.");
        }
    }

    private static Entrada selecionarEntrada(List<Entrada> entradas) {
        if (entradas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma entrada disponível.");
            return null;
        }

        String nome = JOptionPane.showInputDialog(null, "Informe o nome da entrada (ou digite 'não' para pular):");
        if (nome == null || nome.equalsIgnoreCase("não")) {
            return null;
        }

        for (Entrada e : entradas) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "Entrada selecionada: " + e.getNome());
                return e;
            }
        }

        JOptionPane.showMessageDialog(null, "Entrada não encontrada!");
        return selecionarEntrada(entradas);
    }

    private static Prato_principal selecionarPrincipal(List<Prato_principal> principais) {
        if (principais.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum prato principal disponível.");
            return null;
        }

        String nome = JOptionPane.showInputDialog(null, "Informe o nome do prato principal (ou digite 'não' para pular):");
        if (nome == null || nome.equalsIgnoreCase("não")) {
            return null;
        }

        for (Prato_principal p : principais) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "Prato principal selecionado: " + p.getNome());
                return p;
            }
        }

        JOptionPane.showMessageDialog(null, "Prato principal não encontrado!");
        return selecionarPrincipal(principais);
    }

    private static Sobremesa selecionarSobremesa(List<Sobremesa> sobremesas) {
        if (sobremesas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sobremesa disponível.");
            return null;
        }

        String nome = JOptionPane.showInputDialog(null, "Informe o nome da sobremesa (ou digite 'não' para pular):");
        if (nome == null || nome.equalsIgnoreCase("não")) {
            return null;
        }

        for (Sobremesa s : sobremesas) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "Sobremesa selecionada: " + s.getNome());
                return s;
            }
        }

        JOptionPane.showMessageDialog(null, "Sobremesa não encontrada!");
        return selecionarSobremesa(sobremesas);
    }

    // Método para listar os pedidos
    public static void ListarPedido(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sem pedidos cadastrados!");
        } else {
            Collections.sort(pedidos, (p1, p2) -> p1.getCliente().getNome().compareToIgnoreCase(p2.getCliente().getNome()));
            StringBuilder lista = new StringBuilder("___________ PEDIDOS ___________\n");
            for (Pedido pedido : pedidos) {
                lista.append(pedido.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
        Principal_pedido.PedidoMenu();
    }

    // Método para remover um pedido
    public static void RemovePedido(List<Pedido> pedidos) {
        String nomeCliente = JOptionPane.showInputDialog(null, "Informe o nome do cliente que deseja excluir o pedido:");
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome inválido.");
            return;
        }

        boolean removido = pedidos.removeIf(p -> p.getCliente().getNome().equalsIgnoreCase(nomeCliente));

        if (removido) {
            JOptionPane.showMessageDialog(null, "Pedido excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Pedido para o cliente '" + nomeCliente + "' não encontrado.");
        }
        Principal_pedido.PedidoMenu();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
               ", Mesa: " + mesa +
               ", Entrada: " + (entrada != null ? entrada : "Nenhuma") +
               ", Prato Principal: " + (pratoPrincipal != null ? pratoPrincipal : "Nenhum") +
               ", Sobremesa: " + (sobremesa != null ? sobremesa : "Nenhuma") +
               ", Total: R$ " + String.format("%.2f", totalConta);
    }
}