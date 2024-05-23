import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Locacao {
    private String nomeCliente, tipoDoVeiculo, marcaVeiculo, modeloVeiculo;
    private int qtdDiasDeAluguel;
    private double preco, precoDiaria;
    private LocalDate dataInicio, dataFim;
    private boolean devolucao;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }

    public void setTipoDoVeiculo(String tipoDoVeiculo) {
        this.tipoDoVeiculo = tipoDoVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public int getQtdDiasDeAluguel() {
        return qtdDiasDeAluguel;
    }

    public void setQtdDiasDeAluguel(int qtdDiasDeAluguel) {
        this.qtdDiasDeAluguel = qtdDiasDeAluguel;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isDevolucao() {
        return devolucao;
    }

    public void setDevolucao(boolean devolucao) {
        this.devolucao = devolucao;
    }

    public String exibirInfoLocacao() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataInicioFormatada = getDataInicio().format(dateFormatter);
        String dataFimFormatada = getDataFim().format(dateFormatter);

        String infoloc = "Cliente: " + getNomeCliente() + "\n" +
                "Tipo do Veículo: " + getTipoDoVeiculo() + "\n" +
                "Marca do Veículo: " + getMarcaVeiculo() + "\n" +
                "Modelo do Veículo: " + getModeloVeiculo() + "\n" +
                "Valor da diária do Veículo: R$ " + String.format("%.2f", getPrecoDiaria()) + "\n" +
                "Data de Início da Locação: " + dataInicioFormatada + "\n" +
                "Data de Término da Locação: " + dataFimFormatada + "\n" +
                "Quantidade de dias de aluguel: " + getQtdDiasDeAluguel() + " dias" + "\n" +
                "Valor Total da Locação: R$ " + String.format("%.2f", getPreco()) + "\n" +
                "Status Devolução: " + (isDevolucao() ? "Devolvido" : "Não devolvido");
        return infoloc;
    }
}