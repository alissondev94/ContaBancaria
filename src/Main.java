import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conta conta = null;
        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Exibir Estado da Conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Fechar Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:

                    conta = criarConta(sc);
                    break;
                case 2:

                    if (conta != null) {
                        conta.estadoAtual();
                    } else {
                        System.out.println("Nenhuma conta foi criada ainda.");
                    }
                    break;
                case 3:

                    if (conta != null) {
                        System.out.print("Digite o valor para depositar: ");
                        double valorDeposito = sc.nextDouble();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("Nenhuma conta foi criada ainda.");
                    }
                    break;
                case 4:

                    if (conta != null) {
                        System.out.print("Digite o valor para sacar: ");
                        double valorSaque = sc.nextDouble();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("Nenhuma conta foi criada ainda.");
                    }
                    break;
                case 5:

                    if (conta != null) {
                        conta.fecharConta();
                    } else {
                        System.out.println("Nenhuma conta foi criada ainda.");
                    }
                    break;
                case 0:

                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }


    public static Conta criarConta(Scanner sc) {
        Conta novaConta = new Conta();
        novaConta.gerarNumConta();

        System.out.println("Qual tipo de conta deseja abrir? Para conta corrente digite (CC), para conta poupança digite (CP): ");
        String tipoConta = sc.nextLine().toUpperCase();

        if (!tipoConta.equals("CC") && !tipoConta.equals("CP")) {
            System.out.println("Tipo de conta inválido! A conta não foi criada.");
            return null;
        }

        System.out.println("Nome completo do titular:");
        String titular = sc.nextLine();
        novaConta.abrirConta(tipoConta);
        novaConta.setTitular(titular);

        System.out.println("Conta criada com sucesso!");
        novaConta.estadoAtual();

        return novaConta;
    }
}
