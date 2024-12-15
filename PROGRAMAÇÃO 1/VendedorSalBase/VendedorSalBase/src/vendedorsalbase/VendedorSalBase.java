package vendedorsalbase;

import java.util.Scanner;

public class VendedorSalBase {

    public static void main(String[] args) {
        String vendedor[] = {"Bia", "Deo", "Leo", "Nai", "Rui",
            "Ivo", "Gil", "Ian"};
        double salario[] = {600.00, 2000.00, 1000.00, 600.00, 2000.00,
            1000.00, 600.00, 2000.00};
        double vendas[] = {40000.00, 60000.00, 20000.00, 30000.00,
            80000.00, 50000.00, 10000.00, 70000.00};

        Vendedor ven[] = new Vendedor[8];
        System.out.printf("%10s %10s %10s\n", "Vendedor", "Salário",
                "Vendas");
        for (int i = 0; i < ven.length; i++) {
            ven[i] = new Vendedor();
            ven[i].vendedor = vendedor[i];
            ven[i].salarioBase = salario[i];
            ven[i].valorVendas = vendas[i];
            System.out.printf("%10s %10.2f %10.2f\n", ven[i].vendedor,
                    ven[i].salarioBase, ven[i].valorVendas);
        }

        int opcao;
        Scanner scan = new Scanner(System.in);

        do{
        System.out.println("\nMenu\n"
                + "1 – Calcular salário\n"
                + "2 – Calcular médias\n"
                + "3 – Sair \n"
                + "Digite a opção desejada:");
        opcao = scan.nextInt();
        
        switch(opcao){
            case 1:
                /*solicite que o usuário digite o nome de um vendedor e exiba seu salário
                - se  600,00, o salário final é o salário base mais 5% do valor das vendas;
                - se  1000,00, o salário final é o salário base mais 7% do valor das vendas;
                - se  2000,00, o salário final é o salário base mais 10% do valor das vendas.
                */
                System.out.println("Digite o vendedor");
                String vend = scan.next();
                int achou = 0;
                for (int i = 0; i < vendedor.length; i++) {
                    if(vend.equals(ven[i].vendedor)){
                        double salFinal = 0;
                        if(ven[i].salarioBase == 600){
                            salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.05;
                        } else if (ven[i].salarioBase == 1000){
                            salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.07;
                        } else {
                             salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.1;
                        }
                        System.out.println("Salário final: " + salFinal);
                    }
                }        
                break;
        }

        }while(opcao != 3);
    }
}
