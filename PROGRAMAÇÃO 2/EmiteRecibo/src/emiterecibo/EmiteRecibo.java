package emiterecibo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmiteRecibo {
    
    public static void main(String[] args) {
        List<Estoque> est;
        List<ItemVenda> item = new ArrayList<>();
        
        try {
            est = lerDados();
            
            vender(est, item);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmiteRecibo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    Vender: este método recebe um vetor do tipo Estoque e um vetor do tipo
    ItemVenda, solicita que o usuário digite o código do produto e busca 
    tal produto no vetor de Estoque. Para o produto encontrado no vetor 
    estoque, invoca seu método que efetua a venda. A seguir, preenche 
    todos os dados do item de venda e o armazena no vetor de vendas. 
    Repete a operação enquanto o cliente desejar comprar mais produtos.
    No final, invoca o método que emite o recibo da venda realizada.
    
     */
    public static void emitirRecibo (List<ItemVenda> itens){
        FileWriter filw = FileWriter("recibo");
        StringBuilder recibo = new StringBuilder();
        recibo.append("\n Recibo Venda");
        
        recibo.append(String.format("%4s %10s %8s %8s\n", "COD", "DESC", "QTD", "VL UNIT", "VL ITEM"));
        
    }
    public static void vender(List<Estoque> est, List<ItemVenda> item) {  
        StringBuilder message = new StringBuilder();
        
        for (Estoque e : est) {
            message.append(e.toString());
        }
        
        
        int qtd;
        ItemVenda itemLinha;
        int cod;
        
        message.append("\n Digite o código ou -1 para encerrar");
        cod = Integer.parseInt(JOptionPane.showInputDialog(message));
        while(cod > 0){
        for (Estoque e : est) {
            if (e.getCodPro() == cod) {
                qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite "
                        + "a quantidade"));
                e.vender(qtd);
                
                itemLinha = new ItemVenda(cod, e.getDescricao(),
                        qtd, e.getPrecoVendaUnit());
                
                item.add(itemLinha);
                
            }
        }
        //message.append("\n Digite o código ou -1 para encerrar");
        cod = Integer.parseInt(JOptionPane.showInputDialog(message));
    }
    }
    public static List<Estoque> lerDados() throws FileNotFoundException {
        File fil = new File("dados.txt");
        Scanner scan = new Scanner(fil);
        
        List<Estoque> estoque = new ArrayList<>();
        while (scan.hasNext()) {
            Estoque est = new Estoque(scan.nextInt(),
                    scan.next(),
                    scan.nextInt(),
                    scan.nextDouble());
            
            estoque.add(est);
        }
        return estoque;
    }
}
