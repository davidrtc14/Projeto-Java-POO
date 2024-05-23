import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Locadora {

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    private List<Veiculo> veiculos;
    private List<Locacao> listaLocacoes;

    public Locadora() {
        this.listaClientes = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.listaLocacoes = new ArrayList<>();
        settarFuncionarios();
        settarVeiculos();
    }

    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        locadora.exibirMenuInicial();
    }

    private void exibirMenuInicial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, Bem-Vindo a Nossa Locadora de Veículos, selecione uma das opções abaixo:");
        System.out.println("1. Sou Cliente");
        System.out.println("2. Sou Funcionário");
        System.out.println("3. Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                exibirMenuClientes();
                break;
            case 2:
                autenticarFuncionario(scanner);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                exibirMenuInicial();
        }
    }

    private void exibirMenuClientes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cadastre-se");
        System.out.println("2. Alugar um Veículo");
        System.out.println("3. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                cadastrarCliente(scanner);
                break;
            case 2:
                autenticarCadastroCliente(scanner);
                break;
            case 3:
                exibirMenuInicial();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirMenuClientes();
        }
    }

    private void cadastrarCliente(Scanner scanner) {
        System.out.println("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine();
        System.out.println("Digite o seu CPF:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o seu telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o seu e-mail:");
        String email = scanner.nextLine();
        System.out.println("Digite a sua senha:");
        String senha = scanner.nextLine();
        System.out.println("Digite o seu endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite a sua data de nascimento (dd/MM/yyyy):");
        String dataNasc = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNomeCompleto(nomeCompleto);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setEndereco(endereco);
        cliente.setDataNasc(dataNasc);

        listaClientes.add(cliente);
        System.out.println(cliente.getNomeCompleto() + ", você foi cadastrado com sucesso!");
        exibirMenuClientes();
    }

    private void autenticarCadastroCliente(Scanner scanner) {
        System.out.println("Você possui cadastro?\n1. Sim\n2. Não");
        int respostaCliente = scanner.nextInt();
        scanner.nextLine();

        switch (respostaCliente) {
            case 1:
                locarVeiculo(scanner);
                break;
            case 2:
                cadastrarCliente(scanner);
                break;
            default:
                System.out.println("Digite uma opção válida.");
                autenticarCadastroCliente(scanner);
        }
    }

    private void exibirClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.exibirInfoCliente());
            }
        }
        exibirMenuFuncionarios();
    }

    private Cliente encontrarCliente(String email, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getEmail().equalsIgnoreCase(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }

    private void exibirMenuFuncionarios() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Cadastrar Veículo");
        System.out.println("3. Exibir Locações");
        System.out.println("4. Exibir Clientes");
        System.out.println("5. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                cadastrarFuncionario(scanner);
                break;
            case 2:
                cadastrarVeiculo(scanner);
                break;
            case 3:
                exibirLocacoes();
                break;
            case 4:
                exibirClientes();
                break;
            case 5:
                exibirMenuInicial();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirMenuFuncionarios();
        }
    }

    private void settarFuncionarios() {
        Funcionario f1 = new Funcionario("David Ramalho Teixeira de Carvalho", "drtc@locveiculos.com", "123");
        Funcionario f2 = new Funcionario("Arthur Aurélio de Lima", "aadl@locveiculos.com", "456");
        Funcionario f3 = new Funcionario("Arthur Nobrega Martins", "anm@locveiculos.com", "789");
        Funcionario f4 = new Funcionario("Hygor Gabriel Alves Montenegro", "hgam@locveiculos.com", "321");
        Funcionario f5 = new Funcionario("Leonardo Felipe Silva Costa", "lfsc@locveiculos.com", "654");
        Funcionario f6 = new Funcionario("Marcos Pereira Matias Neto", "mpmn@locveiculos.com", "senha123");

        listaFuncionarios.add(f1);
        listaFuncionarios.add(f2);
        listaFuncionarios.add(f3);
        listaFuncionarios.add(f4);
        listaFuncionarios.add(f5);
        listaFuncionarios.add(f6);
    }

    private void autenticarFuncionario(Scanner scanner) {
        System.out.println("Digite o seu Email:");
        String email = scanner.nextLine();
        System.out.println("Digite a sua Senha:");
        String senha = scanner.nextLine();

        Funcionario funcionario = encontrarFuncionario(email, senha);
        if (funcionario != null) {
            exibirMenuFuncionarios();
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            exibirMenuInicial();
        }
    }

    private Funcionario encontrarFuncionario(String email, String senha) {
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
    }

    private void cadastrarFuncionario(Scanner scanner) {
        System.out.println("Digite o nome completo do funcionário:");
        String nomeCompleto = scanner.nextLine();
        System.out.println("Digite o e-mail do funcionário:");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do funcionário:");
        String senha = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nomeCompleto, email, senha);

        listaFuncionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        exibirMenuFuncionarios();
    }

    private void locarVeiculo(Scanner scanner) {

        System.out.println("Digite o seu email:");
        String emailCliente = scanner.nextLine();

        System.out.println("Digite a sua senha:");
        String senhaCliente = scanner.nextLine();

        Cliente cliente = encontrarCliente(emailCliente, senhaCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado ou senha incorreta.");
            autenticarCadastroCliente(scanner);
            return;
        }

        System.out.println("Bem-Vindo " + cliente.getNomeCompleto() + ", Que tipo de veículo você deseja alugar?");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        int escolhaTipo = scanner.nextInt();
        scanner.nextLine();

        List<Veiculo> veiculosDisponiveis = new ArrayList<>();
        String tipoSelecionado = "";

        if (escolhaTipo == 1) {
            tipoSelecionado = "Carro";
            for (Veiculo veiculo : veiculos) {
                if (veiculo.isDisponibilidadeVeiculo() && veiculo instanceof Carro) {
                    veiculosDisponiveis.add(veiculo);
                }
            }
        } else if (escolhaTipo == 2) {
            tipoSelecionado = "Moto";
            for (Veiculo veiculo : veiculos) {
                if (veiculo.isDisponibilidadeVeiculo() && veiculo instanceof Moto) {
                    veiculosDisponiveis.add(veiculo);
                }
            }
        } else {
            System.out.println("Opção inválida. Por favor, selecione 1 para carro ou 2 para moto.");
            exibirMenuClientes();
            return;
        }

        if (veiculosDisponiveis.isEmpty()) {
            System.out.println("Nenhum " + tipoSelecionado.toLowerCase() + " disponível para locação.");
            exibirMenuClientes();
            return;
        }

        System.out.println("-- " + tipoSelecionado + "s Disponíveis --");
        for (int i = 0; i < veiculosDisponiveis.size(); i++) {
            Veiculo veiculo = veiculosDisponiveis.get(i);
            System.out.println((i + 1) + ". " + veiculo.getMarca() + " " + veiculo.getModelo());
        }

        System.out.println("Escolha o " + tipoSelecionado.toLowerCase() + " que deseja alugar (digite o número correspondente):");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > veiculosDisponiveis.size()) {
            System.out.println("Opção inválida.");
            exibirMenuClientes();
            return;
        }

        Veiculo veiculoEscolhido = veiculosDisponiveis.get(escolha - 1);

        System.out.println("Digite a data de início da locação (dd/MM/yyyy):");
        String dataInicioStr = scanner.nextLine();
        System.out.println("Digite a data de término da locação (dd/MM/yyyy):");
        String dataFimStr = scanner.nextLine();

        LocalDate dataInicio, dataFim;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataInicio = LocalDate.parse(dataInicioStr, formatter);
            dataFim = LocalDate.parse(dataFimStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Data em formato inválido.");
            exibirMenuClientes();
            return;
        }

        long diasAluguel = ChronoUnit.DAYS.between(dataInicio, dataFim);
        double precoTotal = diasAluguel * veiculoEscolhido.getPrecoDiariaLocacao();
        veiculoEscolhido.setPrecoTotalLocacao(precoTotal);

        System.out.println("Exbindo informações sobre o veículo escolhido:\n" + veiculoEscolhido.exibirInfo() + "Valor Total da Locação: R$ " + String.format("%.2f", veiculoEscolhido.getPrecoTotalLocacao()) + "\n");

        veiculoEscolhido.setDisponibilidadeVeiculo(false);
        veiculoEscolhido.setDataInicial(dataInicio);
        veiculoEscolhido.setDataFinal(dataFim);
        veiculoEscolhido.setQtdDiasAluguel((int) diasAluguel);

        Locacao locacao = new Locacao();
        locacao.setNomeCliente(cliente.getNomeCompleto());
        locacao.setTipoDoVeiculo(tipoSelecionado);
        locacao.setMarcaVeiculo(veiculoEscolhido.getMarca());
        locacao.setModeloVeiculo(veiculoEscolhido.getModelo());
        locacao.setDataInicio(veiculoEscolhido.getDataInicial());
        locacao.setDataFim(veiculoEscolhido.getDataFinal());
        locacao.setQtdDiasDeAluguel(veiculoEscolhido.getQtdDiasAluguel());
        locacao.setPreco(precoTotal);
        locacao.setPrecoDiaria(veiculoEscolhido.getPrecoDiariaLocacao());
        locacao.setDevolucao(false);

        listaLocacoes.add(locacao);

        System.out.println("Pronto " + locacao.getNomeCliente() + ", o aluguel do seu " + locacao.getMarcaVeiculo() + " " + locacao.getModeloVeiculo() + " foi realizada com sucesso!" + "\nVerifique seu e-mail para mais informações sobre sua locação.");

        exibirMenuClientes();
    }

    private void settarVeiculos() {

        Carro c1 = new Carro();
        c1.setMarca("Volkswagen");
        c1.setModelo("Gol");
        c1.setAno(2022);
        c1.setTipo("Hatch");
        c1.setCor("Prata");
        c1.setPotenciaMotor("1.0 12V");
        c1.setDirecao("Hidráulica");
        c1.setCambio("Manual");
        c1.setQuilometragem(5000.00);
        c1.setPlaca("ABC-1234");
        c1.setCombustivel("Flex");
        c1.setCapacPassag(5);
        c1.setCapacBagagem("285 Litros");
        c1.setPrecoDiariaLocacao(150);
        c1.setTipoVeiculo("Carro");
        c1.setDisponibilidadeVeiculo(true);

        Carro c2 = new Carro();
        c2.setMarca("Chevrolet");
        c2.setModelo("Onix");
        c2.setAno(2022);
        c2.setTipo("Hatch");
        c2.setCor("Preto");
        c2.setPotenciaMotor("1.0 Turbo");
        c2.setDirecao("Elétrica");
        c2.setCambio("Automático");
        c2.setQuilometragem(3000.00);
        c2.setPlaca("DEF-5678");
        c2.setCombustivel("Flex");
        c2.setCapacPassag(5);
        c2.setCapacBagagem("280 Litros");
        c2.setPrecoDiariaLocacao(180);
        c2.setTipoVeiculo("Carro");
        c2.setDisponibilidadeVeiculo(true);

        Carro c3 = new Carro();
        c3.setMarca("Fiat");
        c3.setModelo("Uno");
        c3.setAno(2022);
        c3.setTipo("Hatch");
        c3.setCor("Branco");
        c3.setPotenciaMotor("1.0 Firefly");
        c3.setDirecao("Mecânica");
        c3.setCambio("Manual");
        c3.setQuilometragem(4000.00);
        c3.setPlaca("GHI-9012");
        c3.setCombustivel("Flex");
        c3.setCapacPassag(5);
        c3.setCapacBagagem("280 Litros");
        c3.setPrecoDiariaLocacao(140);
        c3.setTipoVeiculo("Carro");
        c3.setDisponibilidadeVeiculo(true);

        Carro c4 = new Carro();
        c4.setMarca("Renault");
        c4.setModelo("Kwid");
        c4.setAno(2022);
        c4.setTipo("SUV");
        c4.setCor("Vermelho");
        c4.setPotenciaMotor("1.0 12V");
        c4.setDirecao("Elétrica");
        c4.setCambio("Automático");
        c4.setQuilometragem(2000.00);
        c4.setPlaca("JKL-3456");
        c4.setCombustivel("Flex");
        c4.setCapacPassag(5);
        c4.setCapacBagagem("290 Litros");
        c4.setPrecoDiariaLocacao(160);
        c4.setTipoVeiculo("Carro");
        c4.setDisponibilidadeVeiculo(true);

        Carro c5 = new Carro();
        c5.setMarca("Hyundai");
        c5.setModelo("HB20");
        c5.setAno(2022);
        c5.setTipo("Hatch");
        c5.setCor("Azul");
        c5.setPotenciaMotor("1.0 Turbo");
        c5.setDirecao("Elétrica");
        c5.setCambio("Automático");
        c5.setQuilometragem(2500.00);
        c5.setPlaca("MNO-7890");
        c5.setCombustivel("Flex");
        c5.setCapacPassag(5);
        c5.setCapacBagagem("300 Litros");
        c5.setPrecoDiariaLocacao(170);
        c5.setTipoVeiculo("Carro");
        c5.setDisponibilidadeVeiculo(true);

        Moto m1 = new Moto();
        m1.setMarca("Honda");
        m1.setModelo("CG 160 Titan");
        m1.setTipo("Trail");
        m1.setCor("Vermelha");
        m1.setAno(2021);
        m1.setPlaca("RFW-0006");
        m1.setCilindradas(471);
        m1.setCombustivel("Gasolina");
        m1.setQuilometragem(12000);
        m1.setPrecoDiariaLocacao(200);
        m1.setTipoVeiculo("Moto");
        m1.setDisponibilidadeVeiculo(true);

        Moto m2 = new Moto();
        m2.setMarca("Yamaha");
        m2.setModelo("MT-03");
        m2.setTipo("Naked");
        m2.setCor("Azul");
        m2.setAno(2019);
        m2.setPlaca("RFW-0007");
        m2.setCilindradas(847);
        m2.setCombustivel("Gasolina");
        m2.setQuilometragem(6550);
        m2.setPrecoDiariaLocacao(300);
        m2.setTipoVeiculo("Moto");
        m2.setDisponibilidadeVeiculo(true);

        Moto m3 = new Moto();
        m3.setMarca("Kawasaki");
        m3.setModelo("Ninja 300");
        m3.setTipo("Supersport");
        m3.setCor("Verde");
        m3.setAno(2024);
        m3.setPlaca("RFW-0008");
        m3.setCilindradas(998);
        m3.setCombustivel("Gasolina");
        m3.setQuilometragem(2000);
        m3.setPrecoDiariaLocacao(400);
        m3.setTipoVeiculo("Moto");
        m3.setDisponibilidadeVeiculo(true);

        Moto m4 = new Moto();
        m4.setMarca("Suzuki");
        m4.setModelo("Burgman 125");
        m4.setTipo("Scooter");
        m4.setCor("Branca");
        m4.setAno(2022);
        m4.setPlaca("RFW-0009");
        m4.setCilindradas(750);
        m4.setCombustivel("Gasolina");
        m4.setQuilometragem(7870);
        m4.setPrecoDiariaLocacao(350);
        m4.setTipoVeiculo("Moto");
        m4.setDisponibilidadeVeiculo(true);

        Moto m5 = new Moto();
        m5.setMarca("Dafra");
        m5.setModelo("Citycom S 300i");
        m5.setTipo("Scooter");
        m5.setCor("Vermelha");
        m5.setAno(2023);
        m5.setPlaca("RFW-0010");
        m5.setCilindradas(1103);
        m5.setCombustivel("Gasolina");
        m5.setQuilometragem(4300);
        m5.setPrecoDiariaLocacao(600);
        m5.setTipoVeiculo("Moto");
        m5.setDisponibilidadeVeiculo(true);


        veiculos.add(c1);
        veiculos.add(c2);
        veiculos.add(c3);
        veiculos.add(c4);
        veiculos.add(c5);
        veiculos.add(m1);
        veiculos.add(m2);
        veiculos.add(m3);
        veiculos.add(m4);
        veiculos.add(m5);
    }

    private void cadastrarVeiculo(Scanner scanner) {
        System.out.println("Escolha o tipo de veículo a ser cadastrado:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine();

        Veiculo veiculo;
        if (tipoVeiculo == 1) {
            veiculo = cadastrarCarro(scanner);
        } else if (tipoVeiculo == 2) {
            veiculo = cadastrarMoto(scanner);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        exibirMenuFuncionarios();
    }

    private Carro cadastrarCarro(Scanner scanner) {
        Carro carro = new Carro();

        System.out.println("Digite a Marca do Carro:");
        carro.setMarca(scanner.nextLine());

        System.out.println("Digite o Modelo do Carro:");
        carro.setModelo(scanner.nextLine());

        System.out.println("Digite o Ano do Carro:");
        carro.setAno(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Digite o Tipo do Carro:");
        carro.setTipo(scanner.nextLine());

        System.out.println("Digite a Potência do Motor do Carro:");
        carro.setPotenciaMotor(scanner.nextLine());

        System.out.println("Digite o tipo de direção do Carro:");
        carro.setDirecao(scanner.nextLine());

        System.out.println("Digite a Capacidade de Bagagem do Carro:");
        carro.setCapacBagagem(scanner.nextLine());

        System.out.println("Digite a Cor do Carro:");
        carro.setCor(scanner.nextLine());

        System.out.println("Digite a Placa do Carro:");
        carro.setPlaca(scanner.nextLine());

        System.out.println("Digite o Câmbio do Carro:");
        carro.setCambio(scanner.nextLine());

        System.out.println("Digite o Combustível do Carro:");
        carro.setCombustivel(scanner.nextLine());

        System.out.println("Digite a Quilometragem do Carro:");
        carro.setQuilometragem(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Digite a quantidade de lugares do Carro:");
        carro.setCapacPassag(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Digite o valor da diária do Carro:");
        carro.setPrecoDiariaLocacao(scanner.nextDouble());
        scanner.nextLine();

        carro.setTipoVeiculo("Carro");
        carro.setDisponibilidadeVeiculo(true);

        return carro;
    }

    private Moto cadastrarMoto(Scanner scanner) {
        Moto moto = new Moto();
        System.out.println("Digite a Marca da Moto:");
        moto.setMarca(scanner.nextLine());
        System.out.println("Digite o Modelo da Moto:");
        moto.setModelo(scanner.nextLine());
        System.out.println("Digite o Tipo da Moto:");
        moto.setTipo(scanner.nextLine());
        System.out.println("Digite o Ano da Moto:");
        moto.setAno(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Digite a Cor da Moto:");
        moto.setCor(scanner.nextLine());
        System.out.println("Digite a Placa da Moto:");
        moto.setPlaca(scanner.nextLine());
        System.out.println("Digite o Combustível da Moto:");
        moto.setCombustivel(scanner.nextLine());
        System.out.println("Digite a Quilometragem da Moto:");
        moto.setQuilometragem(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Digite quantas cilindradas tem a Moto:");
        moto.setCilindradas(scanner.nextInt());
        System.out.println("Digite o valor da diária da Moto:");
        moto.setPrecoDiariaLocacao(scanner.nextDouble());
        scanner.nextLine();

        moto.setTipoVeiculo("Moto");
        moto.setDisponibilidadeVeiculo(true);

        return moto;
    }

    private void exibirLocacoes() {
        if (listaLocacoes.isEmpty()) {
            System.out.println("Nenhuma locação registrada.");
        } else {
            System.out.println("Lista de Locações Registradas:");
            for (Locacao locacao : listaLocacoes) {
                System.out.println(locacao.exibirInfoLocacao());
                System.out.println("-------------------------");
            }
        }
        exibirMenuFuncionarios();
    }
}