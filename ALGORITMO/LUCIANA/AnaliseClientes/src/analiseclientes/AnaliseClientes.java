
package analiseclientes;
  import java.util.Scanner;

public class AnaliseClientes {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DadosCliente[] cli = new DadosCliente[20000];
        int tc = 0, ttemp = 0, ind = 0;

        for (int i = 0; i < 3; i++) {
            cli[i] = new DadosCliente();

            System.out.println("Digite o nome:");
            cli[i].nome = scanner.nextLine();
            
            System.out.println("Digite o endereco:");
            cli[i].end = scanner.nextLine();
            
            System.out.println("Digite o CPF:");
            cli[i].cpf = scanner.nextLine();
            
            System.out.println("Digite a idade:");
            cli[i].idade = scanner.nextInt();
            
            System.out.println("Digite o número da conta:");
            cli[i].num_conta = scanner.nextInt();
            
            System.out.println("Digite o tempo em que é cliente (meses):");
            cli[i].tempo = scanner.nextInt();
            
            System.out.println("Digite o saldo:");
            cli[i].saldo = scanner.nextDouble();
            
            
            scanner.nextLine(); // Consumir a quebra de linha pendente
            ind = ind + 1;
        }
        
        for (int i = 0; i < ind; i++) {
            System.out.printf("%10s %10s %10s %10d %10d %10d %10.2f\n", cli[i].nome, 
                    cli[i].end, cli[i].cpf, cli[i].idade,cli[i].num_conta,cli[i].tempo,
                    cli[i].saldo );
        }

        tc = calculo1(cli);
        System.out.println("Total de clientes com saldo negativo = " + tc);

        ttemp = calculo2(cli);
        System.out.println("Total de clientes que abriram conta a mais de 10 anos e com idade < 30 = " + ttemp);
    }

    static int calculo1(DadosCliente[] cli) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            if (cli[i].saldo < 0) {
                total++;
            }
        }
        return total;
    }

    static int calculo2(DadosCliente[] cli) {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            if (cli[i].tempo > 120 && cli[i].idade < 30) {
                total++;
            }
        }
        return total;
    }
}

    
    

