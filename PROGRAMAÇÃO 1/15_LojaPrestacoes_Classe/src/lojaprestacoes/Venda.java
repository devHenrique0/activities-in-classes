package lojaprestacoes;

public class Venda {
    
    String cliente;
    double valorBase;
    int numPrest;

    //Exemplos de construtores
    public Venda(){
        // Este é o construtor padrão.
        // É inserido automaticamente pelo compilador.
        // Mas, se inserirmos um outro construtor, o compilador
        // não insere este
    }
    
    public Venda(String cliente, double valorBase, int numPrest) {
        this.cliente = cliente;
        this.valorBase = valorBase;
        this.numPrest = numPrest;
    }    
}



