package lojacompra;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LojaCompra {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
   
        try {
           List<Produto> prod = lerDadosArrayList();
            for (Produto p: prod) {
                System.out.println(p.toString());
            }
            
            int opcao;
          do{
              System.out.println("Menu\n"
                      + "1 - Exibir precos de venda\n"
                      + "2 - Realizar compra\n"
                      + "3 - Sair\n"
                      + "Digite a opcao desejada");
              opcao = scan.nextInt();
              
              switch(opcao){
                  case 1:
                      for (Produto p: prod) {
                          System.out.printf("%10s %10.2f\n", p.getDescricao(),
                                  p.calcPreco());
                      }
                  break;
                  case 2:
                      System.out.println("\nCompra de Produto ");
                      System.out.println("Digite o codigo");
                      int cod = scan.nextInt();
                      System.out.println("Digite a quantidade comprada");
                      int qtd = scan.nextInt();
                      
                      for (Produto p: prod) {
                          if(p.getCodigo() == cod){
                              System.out.println(p.Entrada(qtd));
                              System.out.println("Estoque Atualizado "+ p.getEstoque());
                          }
                      }
                  break;
                  case 3:
                      System.out.println("Encerrado com sucesso");
                      default:
                  break;
              }
          }while(opcao != 3);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
        }
        

    }
////    public static List<Produto> lerDados () throws FileNotFoundException{
////        File fil = new File("dados");
////        Scanner scan = new Scanner(fil);
////        
////        List<Produto> prod = new ArrayList();
////        
////        for (int i = 0; i < 5; i++) {
//////           prod[i] = new Produto(scan.nextInt(), scan.next(), scan.nextInt(), scan.nextDouble()); 
////           
////           Produto p = new Produto();
////           
////           p.setCodigo(scan.nextInt());
////           p.setDescricao(scan.next());
////           p.setEstoque(scan.nextInt());
////           p.setPrecoCompra(scan.nextDouble());
////           
////           prod.add(p);
////           
////        }
////        return prod;
////    }

    public static List<Produto> lerDadosArrayList() throws FileNotFoundException{
        File fil = new File("dados");
        Scanner scan = new Scanner(fil);
        
        List<Produto> produtos = new ArrayList<>();
        
        while(scan.hasNext()){
            Produto prod = new Produto(scan.nextInt(), scan.next(), scan.nextInt(), scan.nextDouble());
            produtos.add(prod);
        }
        return produtos;
    }
}

//import java.io.File;
//import java.io.FileNotFoundException;

//File fil = new File("dados");
//
//        try {
//            Scanner scan = new Scanner(fil);
//
//            Produto prod[] = new Produto[5];
//
//            for (int i = 0; i < prod.length; i++) {
//
//                prod[i] = new Produto(scan.nextInt(), scan.next(),
//                        scan.nextInt(), scan.nextDouble());
//
//                
////            prod.codigo = scan.nextInt();
////            prod.descricao = scan.next();
////            prod.estoque = scan.nextInt();
////            prod.precoCompra = scan.nextDouble();
////            System.out.println(prod.codigo + "  " + prod.descricao + 
////                    " " + prod.estoque + " " + prod.precoCompra);
//                System.out.printf("%10d %10s %10d %10.2f\n", prod[i].codigo, prod[i].descricao, prod[i].estoque,prod[i].precoCompra);
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("Arquivo não encontrado");
//        }