public class ContaPoupanca extends Conta {

    private static final String TIPOCONTA = "Poupança";

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.tipoConta = TIPOCONTA;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===Extrato Conta Poupança===");  
        imprimirInfoConta();
    }

}
