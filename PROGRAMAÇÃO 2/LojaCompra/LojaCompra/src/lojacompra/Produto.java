package lojacompra;

public class Produto {
    private int codigo;	
    private String descricao;	
    private int estoque;
    private double precoCompra;
    
    public double calcPreco(){
        return precoCompra + (precoCompra * 1.2);
    } 

    public Produto (){
        
    }
    
    public String Entrada(int qtd){
        
        estoque = estoque + qtd;
        
        return "Entrada efetuada com sucesso";
    }
    
    public Produto(int cod, String descricao, int estoque, double precoCompra) {
        codigo = cod;
        this.descricao = descricao;
        this.estoque = estoque;
        this.precoCompra = precoCompra;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    @Override
    public String toString(){
       return  String.format("%10d %10s %10d %10.2f", codigo, descricao, estoque, precoCompra);
    }
    
    
}
