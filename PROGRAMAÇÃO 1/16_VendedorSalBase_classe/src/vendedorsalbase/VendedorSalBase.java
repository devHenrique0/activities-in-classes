package vendedorsalbase;

import java.util.Scanner;

public class VendedorSalBase {

    public static void main(String[] args) {
        String vendedor[] = {"Bia", "Deo", "Leo", "Nai", "Rui", "Ivo", "Gil", "Ian"};
        double salario[] = {600.00, 2000.00, 1000.00, 600.00, 2000.00, 1000.00, 600.00, 2000.00};
        double vendas[] = {40000.00, 60000.00, 20000.00, 30000.00, 80000.00, 50000.00, 10000.00, 70000.00};

        Vendedor ven[] = new Vendedor[8];
        System.out.printf("%10s %10s %10s\n", "Vendedor", "Salário", "Vendas");
        for (int i = 0; i < ven.length; i++) {
            ven[i] = new Vendedor();
            ven[i].vendedor = vendedor[i];
            ven[i].salarioBase = salario[i];
            ven[i].valorVendas = vendas[i];
            System.out.printf("%10s %10.2f %10.2f\n", ven[i].vendedor, ven[i].salarioBase, ven[i].valorVendas);
        }

        int opcao;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nMenu\n"
                    + "1 – Calcular salário\n"
                    + "2 – Calcular médias\n"
                    + "3 – Sair \n"
                    + "Digite a opção desejada:");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o vendedor");
                    String vend = scan.next();
                    
                    int achou = 0;
                    
                    for (int i = 0; i < vendedor.length; i++) {
                        
                        if (vend.equals(ven[i].vendedor)) {
                            
                            double salFinal = 0;
                            if (ven[i].salarioBase == 600) {
                                salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.05;
                            } else if (ven[i].salarioBase == 1000) {
                                salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.07;
                            } else {
                                salFinal = ven[i].salarioBase + ven[i].valorVendas * 0.1;
                            }
                            
                            System.out.println("Salário final: " + salFinal);
                                                       
                            achou = 1;
                            
                        }
                    }
                                        
                    if(achou == 0){
                        System.out.println("Vendedor não encontrado");
                    }
                    break;

                case 2:
                    int cont600 = 0,
                        cont1000 = 0,
                        cont2000 = 0;
                    double soma600 = 0,
                           soma1000 = 0,
                           soma2000 = 0;

                    for (int i = 0; i < ven.length; i++) {
                        if (ven[i].salarioBase == 600) {
                            cont600 = cont600 + 1;
                            soma600 = soma600 + ven[i].valorVendas;
                        } else if (ven[i].salarioBase == 1000) {
                            cont1000 = cont1000 + 1;
                            soma1000 = soma1000 + ven[i].valorVendas;
                        } else {
                            cont2000 = cont2000 + 1;
                            soma2000 = soma2000 + ven[i].valorVendas;
                        }
                    }
                    double media600 = soma600 / cont600;
                    double media1000 = soma1000 / cont1000;
                    double media2000 = soma2000 / cont2000;

                    System.out.println("Média de vendas do vendedores que ganham  600: " + media600);
                    System.out.println("Média de vendas do vendedores que ganham 1000: " + media1000);
                    System.out.println("Média de vendas do vendedores que ganham 2000: " + media2000);
            }

        } while (opcao != 3);
    }
}