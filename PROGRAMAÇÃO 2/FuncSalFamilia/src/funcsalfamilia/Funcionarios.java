package funcsalfamilia;

public class Funcionarios {

    private String nome;
    private double salarioBase;
    private int numFilhos;
    
    public double calcSal(){
        if(salarioBase <= 1655.98){
            return salarioBase + numFilhos * 56.47;
        }else{
            return salarioBase;
        }
    }

    public Funcionarios(String nome, double salarioBase, int numFilhos) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.numFilhos = numFilhos;
    }

    public int getNumFilhos() {
        return numFilhos;
    }

    public void setNumFilhos(int numFilhos) {
        this.numFilhos = numFilhos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    @Override
    public String toString(){
        return String.format("%10s %10.2f %10d", nome, salarioBase, numFilhos);
    }
}
