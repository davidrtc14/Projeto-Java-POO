public class Cliente {
    private String nomeCompleto, cpf, telefone, email, senha, endereco, dataNasc;

    public Cliente(){}

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getDataNasc(){
        return dataNasc;
    }

    void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    String exibirInfoCliente() {
        String info = "Nome Completo: " + getNomeCompleto() + "\n" +
                "Cpf: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Data de Nascimento: " + getDataNasc() + "\n";
        return info;
    }
}