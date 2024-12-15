package emiterecibo;

public class ItemVenda {
    private int codPro;
    private String descricao;
    private int qtdVenda;
    private double precoVendaUnit;
    private double precoFinal;
    
// 1 - inserir getters e setters
// 2 - implementar o método calcularPrecoFinal, void sem parâmetro
// 3 - inserir o construtor, sem o preço final nos parâmetros
// 4 - chamar o calcularPrecoFinal no construtor

    public ItemVenda(int codPro, String descricao, int qtdVenda, double precoVendaUnit) {
        this.codPro = codPro;
        this.descricao = descricao;
        this.qtdVenda = qtdVenda;
        this.precoVendaUnit = precoVendaUnit;
        
        precoFinal = qtdVenda * precoVendaUnit;
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

    public double getPrecoVendaUnit() {
        return precoVendaUnit;
    }

    public void setPrecoVendaUnit(double precoVendaUnit) {
        this.precoVendaUnit = precoVendaUnit;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
}

// aula de ontem
//
//    public ItemVenda(int codPro, String descricao, int qtdVenda, 
//            double precoVendaUnit) {
//        this.codPro = codPro;
//        this.descricao = descricao;
//        this.qtdVenda = qtdVenda;
//        this.precoVendaUnit = precoVendaUnit;
//    }
//
//    public double getPrecoVendaUnit() {
//        return precoVendaUnit;
//    }
//
//    public void setPrecoVendaUnit(double precoVendaUnit) {
//        this.precoVendaUnit = precoVendaUnit;
//    }
//
//    public int getCodPro() {
//        return codPro;
//    }
//
//    public void setCodPro(int codPro) {
//        this.codPro = codPro;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public int getQtdVenda() {
//        return qtdVenda;
//    }
//
//    public void setQtdVenda(int qtdVenda) {
//        this.qtdVenda = qtdVenda;
//    }
//
//    public double getPrecoFinal() {
//        return precoFinal * qtdVenda;
//    }
//
//    public void setPrecoFinal(double precoFinal) {
//        this.precoFinal = precoFinal * qtdVenda;
//    }
