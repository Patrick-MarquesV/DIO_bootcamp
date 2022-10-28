package Main;

public class ContaCorrente extends Conta {

    private static final String TIPOCONTA = "Corrente";
 
    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.tipoConta = TIPOCONTA;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===Extrato Conta Corrente===");
        imprimirInfoConta();
    }


}
