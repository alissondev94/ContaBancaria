public class Conta {
    public int numConta;
    protected String tipo;
    private String titular;
    private double saldo;
    private boolean status;


    public Conta() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public void abrirConta(String tipoConta) {
        this.setTipo(tipoConta);
        if (tipoConta.equals("CC")) {
            this.setStatus(true);
            this.setSaldo(50);
            System.out.println("Conta corrente aberta com sucesso!");
        } else if (tipoConta.equals("CP")) {
            this.setStatus(true);
            this.setSaldo(150);
            System.out.println("Conta poupança aberta com sucesso!");
        } else {
            this.setStatus(false);
            System.out.println("Tipo de conta inválido!");
        }
    }

    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Há saldo em sua conta. Saque R$ " + this.getSaldo() + " para encerrar a conta.");
        } else if (this.getSaldo() < 0) {
            System.out.println("Saldo negativo. Pague o débito para encerrar a conta.");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Depósito efetuado com sucesso");
        } else {
            System.out.println("Impossível depositar em conta inativa.");
        }
    }

    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() < valor) {
                System.out.println("Saldo insuficiente");
            } else {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado com sucesso.");
            }
        } else {
            System.out.println("Impossível sacar de uma conta inativa.");
        }
    }

    public void gerarNumConta() {
        int conta = 100000 + (int) (Math.random() * 900000);
        this.setNumConta(conta);
    }


    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void estadoAtual() {
        System.out.println("----------------------------------");
        System.out.println("Número da Conta: " + getNumConta());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Status da conta: " + (getStatus() ? "Ativa" : "Inativa"));
        System.out.println("----------------------------------");
    }
}
