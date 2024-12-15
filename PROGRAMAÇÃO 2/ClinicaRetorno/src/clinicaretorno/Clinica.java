package clinicaretorno;

public class Clinica {

    private String paciente;
    private int convenio;
    private double valorBase;
    private char categoria;

    public Clinica(String paciente,
            int convenio,
            double valorBase,
            char categoria) {

        this.paciente = paciente;
        this.convenio = convenio;
        this.valorBase = valorBase;
        this.categoria = categoria;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%10s %10d %10.2f %10c\n",
                paciente, convenio,
                valorBase, categoria);
    }

    public double calcValor() {
        if (categoria == 'r') {
            return 0;
        } else if (convenio == 1) {
            return valorBase;
        } else if(convenio == 2){
            return valorBase * 0.5;
        } else {
            return valorBase * 0.3;
        }
    }
}
