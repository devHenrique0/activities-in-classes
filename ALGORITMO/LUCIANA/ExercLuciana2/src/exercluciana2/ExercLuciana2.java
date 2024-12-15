
package exercluciana2;

import java.util.Scanner;


public class ExercLuciana2 {

   
    public static void main(String[] args) {
       Scanner scan = new Scanner (System.in);
        
        Produto prod[] = new Produto[10];
        for (int i = 0; i < prod.length; i++) {
            prod[i] = new Produto ();
        }
        int achou, ind = 0;
        
        int opcao;
        do{
            System.out.println("\n MENU \n"
                    +"1 - Cadastrar produtos\n"
                    +"2 - consultar produtos por categoria"
                    +"3 - Entrada ou saida"
                    +"4 - Sair");
                    opcao = scan.nextInt();
                    
                    switch(opcao){
                        case 1:
                            achou = 0;
                            System.out.println("####CADASTRO####");
                            System.out.println("Digite o codigo");
                            int codigo = scan.nextInt();
                            for (int i = 0; i < prod.length; i++) {
                                if(codigo == prod[i].codigo){
                                    achou =  1;
                                }
                            }
                            if(achou == 1){
                                System.out.println("Codigo já digitado");
                            }else{
                                prod[ind].codigo = codigo;
                                System.out.println("Digite a descricao");
                                prod[ind].descricao = scan.next();
                                System.out.println("Digite a categoria");
                                prod[ind].categoria = scan.next();
                                System.out.println("Digite o preco unitario");
                                prod[ind].precoUnitario = scan.nextDouble();
                                System.out.println("Digite a quantidade");
                                prod[ind].qtde = scan.nextInt();
                                ind = ind + 1;
                            }
                            System.out.println("Dados Cadastrados");
                            for (int i = 0; i < ind; i++) {
                                System.out.printf("%10d %10s %10s %10.2f %10d", prod[i].codigo, prod[i].descricao, prod[i].categoria, prod[i].precoUnitario, prod[i].qtde);
                            }
                        break;
                        
                    }
        }while(opcao != 4);
        
    }
    
}
