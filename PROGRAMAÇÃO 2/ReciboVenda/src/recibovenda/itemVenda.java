
package recibovenda;

public class itemVenda {
private int codPro;
private String descricao;
private int qtdVenda;
private double precoVendaUnit;
private double precoFinal;

    public itemVenda(int codPro, String descricao, int qtdVenda, double precoVendaUnit, double precoFinal) {
        this.codPro = codPro;
        this.descricao = descricao;
        this.qtdVenda = qtdVenda;
        this.precoVendaUnit = precoVendaUnit;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal * qtdVenda;
    }


    public double getPrecoVendaUnit() {
        return precoVendaUnit;
    }

    public void setPrecoVendaUnit(double precoVendaUnit) {
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

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }


}
