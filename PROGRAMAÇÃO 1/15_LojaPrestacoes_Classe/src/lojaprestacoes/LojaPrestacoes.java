package lojaprestacoes;

import java.util.Scanner;

public class LojaPrestacoes {

    public static void main(String[] args) {
                
        Scanner scan = new Scanner(System.in);
        
        Venda ven[] = new Venda[10];

        String cliente[] = {"Ana", "Luis", "Bia", "Ivo", "Ana", "Luis", "Bia", "Ana", "Bia", "Ian"};
        double valorBase[] = {400.00, 700.00, 200.00, 900.00, 500.00, 800.00, 100.00, 600.00, 300.00, 150.00};
        int numPrestacoes[] = {1, 2, 1, 3, 2, 3, 1, 3, 2, 1};

        for (int i = 0; i < ven.length; i++) {
            ven[i] = new Venda();
            ven[i].cliente = cliente[i];
            ven[i].valorBase = valorBase[i];
            ven[i].numPrest = numPrestacoes[i];
            System.out.printf("%10s %10.2f %10d\n", ven[i].cliente,
                    ven[i].valorBase,
                    ven[i].numPrest);
        }
   
        int opcao;

        do {
            System.out.println("\nMenu\n"
                    + "1 – Maior venda\n"
                    + "2 – Entrada caixa\n"
                    + "3 – Fechar caixa\n"
                    + "4 – Sair\n"
                    + "Digite a opção desejada:");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    double maiorVenda = ven[0].valorBase;
                    String cliMaiorVenda = ven[0].cliente;
                    int numPrestMaior = ven[0].numPrest;

                    for (int i = 0; i < ven.length; i++) {
                        if (ven[i].valorBase > maiorVenda) {
                            maiorVenda = ven[i].valorBase;
                            cliMaiorVenda = ven[i].cliente;
                            numPrestMaior = ven[i].numPrest;
                        }
                    }
                    System.out.println("Cliente maior valor: " + cliMaiorVenda);
                    if (numPrestMaior == 1) {
                        System.out.println("Venda à vista");
                    } else if (numPrestMaior == 2) {
                        System.out.println("Venda em 2 prestações");
                    } else {
                        System.out.println("Venda em 3 prestações");
                    }
                    break;

                case 2:
                    //boolean achou = false;
                    int achou = 0;
                    System.out.println("Digite o cliente");
                    String cli = scan.next();
                    for (int i = 0; i < ven.length; i++) {
                        if (cli.equalsIgnoreCase(ven[i].cliente)) {
                            achou = 1;
                            double valor = 0;
                            if (ven[i].numPrest == 1) {
                                valor = ven[i].valorBase - ven[i].valorBase * 0.05;
                            } else if (ven[i].numPrest == 2) {
                                valor = ven[i].valorBase / 2;
                            } else {
                                valor = (ven[i].valorBase + ven[i].valorBase * 0.05) / 3;
                            }
                            System.out.println("Valor a pagar: " + valor);
                        }
                    }
                    if (achou == 0) {
                        System.out.println("Cliente não encontrado");
                    }

                    break;
            }
        } while (opcao != 4);
    }
}
