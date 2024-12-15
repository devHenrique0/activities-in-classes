package clinicaretorno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClinicaRetorno {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            List<Clinica> cli = lerDados();
            for (Clinica c : cli) {
                System.out.print(c.toString());
            }

            int opcao;
            do{
            System.out.println("\nMenu\n"
                    + "1 – Listar pacientes e valores\n"
                    + "2 – Porcentagem retorno\n"
                    + "3 – Sair\n"
                    + "Digite a opção desejada:");
            opcao = scan.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Digite o convênio");
                    int conv = scan.nextInt();
                    
                    calcValor(cli, conv);
                            
                break;
                case 2:
                    System.out.println("Porcentagem de categoria r: "+ calcPerc(cli)+"%");
                    
                break;
                case 3:
                    
                break;
            }            
            }while(opcao != 3);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClinicaRetorno.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Arquivo não encontrado");
        }
    }

    public static void calcValor(List<Clinica> cli, int convenio) {
        for (Clinica c : cli) {
            if (c.getConvenio() == convenio) {
                System.out.println(c.getPaciente() + "   "
                        + c.calcValor());
            }
        }
    }

    public static List<Clinica> lerDados() throws FileNotFoundException {
        File fil = new File("dados");
        Scanner scan = new Scanner(fil);
        List<Clinica> cli = new ArrayList<>();
        while (scan.hasNext()) {
            Clinica c = new Clinica(scan.next(), scan.nextInt(), scan.nextDouble(), scan.next().charAt(0));

            cli.add(c);
        }
        return cli;
    }
    
    public static double calcPerc (List<Clinica> cli){
        int cont_r = 0;
        for(Clinica c: cli){
           if(c.getCategoria() == 'r'){
                cont_r++;
            }
          }
        double perc = (double)cont_r/cli.size()*100;
        return perc;
    }
    

}

//Crie um aplicativo em Java para controlar uma clínica médica. Os dados da consulta são: o nome do paciente; o código do
//convênio que pode ser particular (1), topmed (2) e polimed (3) e categoria que pode ser consulta normal (c) e retorno (r).
//paciente convenio valorBase categoria

//                  Bia  1  200,00  c
//                  Nair 2  300,00  c
//                  Ivo  1  250,00  r
//                  Luiz 3  200,00  c
//                  Nei  2  200,00  r
//                  Gil  3  250,00  r
//                  Ari  2  300,00  c
//                  Iumi 2  250,00  c
//                  Rui  1  300,00  r
//                  Leo  3  200,00  c

//1) Crie uma classe para manter os dados da consulta, todos private, crie métodos get e set para eles. Crie um construtor que
//receba os atributos da consulta, como parâmetros, e armazene-os nos campos da classe. Sobrecarregue o método toString para
//fornecer uma saída formatada e exibir os dados como na tabela acima.

//2) Nesta classe, implemente um método que calcule e retorne o valor da consulta, que é obtido da seguinte forma: 
//        - Se a categoria da consulta for r (retorno), não há cobrança
//        - Se a consulta for p (particular), o valor final é o valor base
//        - Se o convênio for 2 (topmed), o valor final é 50% do valor base
//        - Se o convênio for 3 (polimed), o valor final é 30% do valor base

//3) Na classe principal, implemente um método para ler os dados em um arquivo de texto, armazenar em um vetor e exibir. 

//4) Na classe principal, implemente um método que recebe o vetor de consultas e o código de um convênio e exibe os nomes
//dos pacientes que foram atendidos pelo convênio recebido e o valor final que cada um pagou. Se o convênio informado não
//for encontrado, exiba mensagem "Convênio não encontrado”.

//5) Na classe principal, implemente um método que recebe um vetor de consultas, calcula e retorna a porcentagem de consultas
//que são da categoria retorno (r).

//5) Invoque o método que carrega e exibe os dados. 

//6) Crie o seguinte menu de opções (incluir mensagem de opção inválida, com a cláusula default): 
//                    Menu
//                    1 – Listar pacientes e valores
//                    2 – Porcentagem retorno
//                    3 – Sair
//                    Digite a opção desejada:

//7) Na opção 1, solicite que o usuário digite o convênio de interesse e exiba os nomes dos pacientes que têm o convênio digitado
//e quanto cada um pagou pela consulta. 

//6) Na opção 2, exiba a porcentagem de consultas da categoria retorno.

//7) Qual a diferença na chamada de um método void e um não void?