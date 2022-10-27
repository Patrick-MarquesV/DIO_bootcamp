public class Main {
    public static void main(String[] args) {

        Cliente joao = new Cliente();
        joao.setNome("Joao");

        Conta cc = new ContaCorrente(joao);

        cc.depositar(100);

        Conta cp = new ContaPoupanca(joao);

        cc.transferir(100, cp);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
        
        Menu.exibir();


    }
}
