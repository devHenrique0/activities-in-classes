
package lojaestoqueminimo;


public class Produto {
    
    private int codigo;
    private String descricao;
    private int estoque;
    private int estoqueMinimo;
    private double precoUnit;
    
    public boolean temEstoque(int qtd){
        return qtd <= estoque;
    }
    
    public double calcvalor(int serVendida){
        estoque = estoque - serVendida;
        
        double valor = serVendida * precoUnit;
                
        return valor;
    }
    
    public String verificaEstoque(){
        if(estoque > estoqueMinimo){
            return "Estoque normal";
        }else if(estoque == estoqueMinimo){
            return "Estoque critico";
        }else{
            return "Estoque baixo";
        }
        
    }

    public Produto(int codigo, String descricao, int estoque, int estoqueMinimo, double precoUnit) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.precoUnit = precoUnit;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
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

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    
    
    @Override
    public String toString(){
        return String.format("%10d %10s %10d %10d %10.2f", codigo, descricao, estoque, estoqueMinimo, precoUnit );
    }
}
