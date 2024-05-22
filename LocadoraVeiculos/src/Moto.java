public class Moto extends Veiculo{
    private double cilindradas;

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
    }

    String exibirInfo() {
        String info = super.exibirInfo() +
                "Cilindradas: " + getCilindradas() + "\n";
        return info;
    }
}