package recibovenda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ReciboVenda {

    
    public static void main(String[] args) {
            List<Estoque>  est; 
            List<itemVenda> item = new ArrayList<>();
        try {
            est = lerDados();
            String message = "";
            for (Estoque e: est) {
                message += e.toString();
            }
                JOptionPane.showMessageDialog(null, message);
                vender (est, item);
                
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Aquivo não Econtrado");
        }
    }
    
    public static void vender(List<Estoque> est, List<itemVenda> item) {
        
        String message = "";
            for (Estoque e: est) {
                message += e.toString();
            }
        message += "\nDigite o código";
        
        int cod = Integer.parseInt(JOptionPane.showInputDialog(message));
        
        int qtd;
        itemVenda itemLinha;
        for (Estoque e: est) {
            if(e.getCodPro() == cod){
                qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));
                e.efetuarVenda(qtd);
                
                itemLinha = new itemVenda(cod, e.getDescricao(), qtd, e.getPrecoVendaUnit(), qtd * e.);
            }
        }
    }
    
    public static List<Estoque> lerDados() throws FileNotFoundException{
        File fil = new File("dados.txt");
        Scanner scan = new Scanner(fil);
        List<Estoque> estoque = new ArrayList<>();
        
        while(scan.hasNext()){
            Estoque est = new Estoque (scan.nextInt(), scan.next(), scan.nextInt(), scan.nextDouble());
            estoque.add(est);
        }
        return estoque;
    }
}
