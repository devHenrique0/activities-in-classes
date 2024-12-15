package prova;

import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {

        String nome[] = {"Rui", "Iumi", "Nei", "Susi", "Alan", "Ian", "Bia", "Gil"};
        double salarioBase[] = {3000.00, 1000.00, 800.00, 1800.00, 1100.00, 1500.00, 1200.00, 900.00};
        int numFilhos[] = {4, 2, 2, 0, 1, 3, 3, 0};

        Funcionarios fun[] = new Funcionarios[8];
        System.out.printf("%10s %10s %10s\n", "Vendedor", "Categoria", "Valor Vendas");
        
        for (int i = 0; i < fun.length; i++) {
            fun[i] = new Funcionarios();
            fun[i].nome =  nome[i];
            fun[i].salarioBase = salarioBase[i];
            fun[i].numFilhos = numFilhos[i];
            System.out.printf("%10s %10.2f %10d\n", fun[i].nome, fun[i].salarioBase, fun[i].numFilhos);
        }
        
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n Menu \n"
                    + "1- Exibir Salario Base\n"
                    + "2- Aumentar Salario\n"
                    + "3- Sair\n"
                    + "Digite a opcao desejada: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome de um funcionário:");
                    String nomeBusca = scan.next();
                    boolean encontrado = false;
                    double salarioFamilia = 0;
                    double salfam = 0;
                    for (int i = 0; i < nome.length; i++) {
                        if (nomeBusca.equals(fun[i].nome)) {
                            if (fun[i].salarioBase <= 1700) {
                                salarioFamilia = fun[i].numFilhos * 70;
                                salfam = salarioFamilia + fun[i].salarioBase;
                                System.out.println("O valor final do salario"+salfam);
                            }
                           
                                
                            encontrado = true;
                            break;
                        }
                        else{
                        
                        }
                        
                    }
                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                    

                case 2:
                    System.out.println("Digite o percentual de aumento:");
                    double percentualAumento = scan.nextDouble();
                    for (int i = 0; i < salarioBase.length; i++) {
                        double aumento = salarioBase[i] * (percentualAumento / 100);
                        salarioBase[i] += aumento;
                        double salarioFamiliaa = (salarioBase[i] <= 1700) ? (numFilhos[i] * 70) : 0;
                        System.out.println("Novo salário de " + fun[i].nome + ": R$" + (salarioBase[i] + salarioFamiliaa));
                    }
                            
                    break;

                case 3:
                    System.out.println("Comando encerrado");
                    break;

                default:
                    System.out.println("Opcao invalida");
                            
            }
        } while (opcao != 3);
    }
}
