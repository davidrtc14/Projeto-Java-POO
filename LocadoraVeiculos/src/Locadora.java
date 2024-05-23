import java.util.Scanner;

public class Locadora {

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
                break;
            case 2:
                break;
            case 3:
                exibirMenuInicial();
                break;
            default:
                System.out.println("Opção inválida.");
                exibirMenuClientes();
        }
    }
}