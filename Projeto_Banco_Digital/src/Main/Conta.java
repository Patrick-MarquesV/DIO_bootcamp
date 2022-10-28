package Main;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;  
    protected String tipoConta;

    
    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    @Override
    public void sacar(double valor) {
        
        if(this.saldo < valor) 
        System.out.println("Saldo Insuficiente!");
        else{
            this.saldo -= valor;        
            System.out.println("Saque efetuado!");
        }
        
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;        
        System.out.println("Deposito efetuado!");
    }
    
    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);        
        System.out.println("Transferência concluída!");
    }
    
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getTipoConta() {
        return tipoConta;
    }
    
    protected void imprimirInfoConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Tipo conta: %s", this.tipoConta));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    protected void imprimirContas() {
        System.out.printf("Titular: %s | Tipo de Conta: %s | Agencia: %s | Mumero da Conta: %d\n", this.cliente.getNome(), this.getTipoConta(), this.getAgencia(), this.getNumero());
    }

    @Override
    public String toString() {
        return agencia + "\t|\t" + numero + "\t|\t" + saldo + "\t|\t" + cliente.getNome()   
                + "\t|\t" + tipoConta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + agencia;
        result = prime * result + numero;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        if (agencia != other.agencia)
            return false;
        if (numero != other.numero)
            return false;
        return true;
    }

}
