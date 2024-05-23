import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Locadora {

    private List<Cliente> listaClientes;

    public Locadora() {
        this.listaClientes = new ArrayList<>();

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
}