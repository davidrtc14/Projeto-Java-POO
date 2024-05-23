import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Locadora {

    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;

    public Locadora() {
        this.listaClientes = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
        settarFuncionarios();

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
                break;
            case 3:
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
}