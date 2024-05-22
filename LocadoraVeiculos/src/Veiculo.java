import java.time.LocalDate;

public abstract class Veiculo {

    private String tipoVeiculo, modelo, marca, tipo, cor, placa, combustivel;
    private int ano, qtdDiasAluguel;
    private double quilometragem, precoDiariaLocacao, precoTotalLocacao;
    private LocalDate dataInicial, dataFinal;
    private boolean disponibilidadeVeiculo;

    public Veiculo() {

    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public int getAno() {
        return ano;
    }

    public int getQtdDiasAluguel() {
        return qtdDiasAluguel;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public double getPrecoDiariaLocacao() {
        return precoDiariaLocacao;
    }

    public double getPrecoTotalLocacao() {
        return precoTotalLocacao;
    }

    public boolean isDisponibilidadeVeiculo() {
        return disponibilidadeVeiculo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setQtdDiasAluguel(int qtdDiasAluguel) {
        this.qtdDiasAluguel = qtdDiasAluguel;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setPrecoDiariaLocacao(double precoDiariaLocacao) {
        this.precoDiariaLocacao = precoDiariaLocacao;
    }

    public void setPrecoTotalLocacao(double precoTotalLocacao) {
        this.precoTotalLocacao = precoTotalLocacao;
    }

    public void setDisponibilidadeVeiculo(boolean disponibilidadeVeiculo) {
        this.disponibilidadeVeiculo = disponibilidadeVeiculo;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    String exibirInfo() {
        String info = "Tipo: " + getTipoVeiculo() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Marca: " + getMarca() + "\n" +
                "Ano: " + getAno() + "\n" +
                "Tipo: " + getTipo() + "\n" +
                "Cor: " + getCor() + "\n" +
                "Placa: " + getPlaca() + "\n" +
                "Combustível: " + getCombustivel() + "\n" +
                "Quilometragem: " + getQuilometragem() + " KM" + "\n" +
                "Valor da diária do Veículo: R$ " + String.format("%.2f", getPrecoDiariaLocacao()) + "\n" +
                "Disponibilidade: " + (isDisponibilidadeVeiculo() ? "Disponível" : "Não disponível") + "\n";
        return info;
    }
}