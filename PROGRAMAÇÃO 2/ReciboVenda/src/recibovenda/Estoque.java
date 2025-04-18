package recibovenda;

public class Estoque {
    private int codPro; 
    private String descricao; 
    private int estoque; 
    private double precoVendaUnit;

    public double efetuarVenda (int qtd){
        estoque = estoque - qtd;
        return qtd* precoVendaUnit ;
    }
    
    public Estoque(int codPro, String descricao, int estoque, double precoVendaUnit) {
        this.codPro = codPro;
        this.descricao = descricao;
        this.estoque = estoque;
        this.precoVendaUnit = precoVendaUnit;
    }
    
    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
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

    public double getPrecoVendaUnit() {
        return precoVendaUnit;
    }

    public void setPrecoVendaUnit(double precoVendaUnit) {
        this.precoVendaUnit = precoVendaUnit;
    }

    @Override
    public String toString() {
        return String.format("%10d %10s %10d %10.2f \n", codPro, descricao, estoque, precoVendaUnit);
    }
    
    
}
