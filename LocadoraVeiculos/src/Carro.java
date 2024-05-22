public class Carro extends Veiculo {

    private String potenciaMotor, direcao, cambio, capacBagagem;
    private int capacPassag;

    public String getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(String potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getCapacBagagem() {
        return capacBagagem;
    }

    public void setCapacBagagem(String capacBagagem) {
        this.capacBagagem = capacBagagem;
    }

    public int getCapacPassag() {
        return capacPassag;
    }

    public void setCapacPassag(int capacPassag) {
        this.capacPassag = capacPassag;
    }

    String exibirInfo() {
        String info = super.exibirInfo() +
                "Potência do Motor: " + getPotenciaMotor() + "\n" +
                "Direção: " + getDirecao() + "\n" +
                "Capacidade de Bagagem: " + getCapacBagagem() + "\n" +
                "Capacidade de Passageiros: " + getCapacPassag() + " Passageiros" + "\n";
        return info;
    }

}

