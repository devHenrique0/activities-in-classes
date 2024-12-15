package exeralgoritmo;
import java.util.Scanner;

public class ExerAlgoritmo {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        
        Conta con[] = new Conta[10];
        for (int i = 0; i < con.length; i++) {
            con[i] = new Conta ();
        }
        
        int ind = 0;
        int opcao;
        double saque, total, deposito, resultado;
        do {
            System.out.println("\n MENU \n"
                    + "1 - Fazer Cadastro\n"
                    + "2 - Visualizar todas as contas cadastradas\n"
                    + "3 - Realizar um saque\n"
                    + "4 - Realizar um depósito\n"
                    + "5 - Para Sair\n"
                    + "Digite a opção desejada ");
            opcao = scan.nextInt();
                     
            switch (opcao) {
                case 1:
                    System.out.println("####CADASTRO####\n");
                    System.out.println("Digite o numero da conta: ");
                    int novaConta = scan.nextInt();

                    boolean contaRepetida = false;
                    for (int i = 0; i < ind; i++) {
                        if (novaConta == con[i].conta) {
                            contaRepetida = true;
                            break;
                        }
                    }

                    if (contaRepetida) {
                        System.out.println("Conta já cadastrada");
                    } else {
                        con[ind].conta = novaConta;
                        System.out.println("Digite o tipo ");
                        con[ind].tipo = scan.next();
                        System.out.println("Digite o nome");
                        con[ind].cliente = scan.next();
                        System.out.println("Digite o CPF");
                        con[ind].cpf = scan.nextLong();
                        System.out.println("Digite o telefone");
                        con[ind].telefone = scan.next();
                        System.out.println("Digite o saldo");
                        con[ind].saldo = scan.nextDouble();
                        ind = ind + 1;
                    }
                    break;
                case 2:
                    System.out.println("Dados Cadastrados");
                    System.out.printf("%10s %10s %10s %10s %10s %10s\n",
                            "Conta", "Tipo", "Cliente", "CPF", "Telefone", "saldo");

                    for (int i = 0; i < ind; i++) {
                        System.out.printf("%10d %10s %10s %10d %10s %10.2f\n",
                                con[i].conta, con[i].tipo, con[i].cliente, con[i].cpf, con[i].telefone, con[i].saldo);
                    }
                break;
                
                case 3:
                    System.out.println("Digite o número da conta para o saque: ");
                    int numeroContaSaque = scan.nextInt();

                    boolean encontrou = false;
                    for (int i = 0; i < ind; i++) {
                        if (con[i].conta == numeroContaSaque) {
                            System.out.println("Digite o quanto você quer sacar: ");
                            saque = scan.nextDouble();
                            total = con[i].saldo - saque;
                            con[i].saldo = total;
                            System.out.println("Saque realizado com sucesso. Novo saldo: " + total);
                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Conta não encontrada.");
                    }
                break;
                
                case 4:
                    System.out.println("Digite o número da conta para o saque: ");
                    int numeroContaDeposito = scan.nextInt();

                    boolean achou = false;
                    for (int i = 0; i < ind; i++) {
                        if (con[i].conta == numeroContaDeposito) {
                            System.out.println("Digite o quanto você quer depositar: ");
                            deposito = scan.nextDouble();
                            resultado = con[i].saldo + deposito;
                            con[i].saldo = resultado;
                            System.out.println("Deposito realizado com sucesso. Novo saldo: " + resultado);
                            achou = true;
                            break;
                        }
                    }

                    if (!achou) {
                        System.out.println("Conta não encontrada.");
                    }
                break;    
            }
        } while (opcao != 5);
    }
}

