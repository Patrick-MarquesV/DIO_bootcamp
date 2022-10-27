import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Menu {

    private static Scanner input = new Scanner(System.in);
    private static Map<Integer, Cliente> clientes = new TreeMap<>();
    private static List<Conta> contas = new ArrayList<>();
    private static int SEQUENCIAL = 1;

    public static void exibir() {
            System.out.println("==== Menu do cliente ====");
            System.out.println("1 - Exibir extrato da conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar valor em conta");
            System.out.println("4 - Sacar valor da conta");
            System.out.println("5 - Transferir valor para conta");
            System.out.println("6 - Cadastrar cliente");
            System.out.println("7 - Abrir nova conta");
            System.out.println("8 - Listar clientes");
            System.out.println("9 - Sair...");
            System.out.println();
            
            avaliaEntrada(solicitaEntrada());
    }

    
    private static int solicitaEntrada() {
        
        int opcaoDesejada = 0;
        
        System.out.print("Digite a opção desejada: ");
        
        try{
            opcaoDesejada = input.nextInt();
            input.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Por favor, insira um valor válido!");
        }     
        
        return opcaoDesejada;
        
    }
    
    private static void avaliaEntrada(int entrada) {
        switch(entrada){
            case 1:
                exibirExtrato();
                exibir();
                break;
            case 2: 
                listarContas();
                exibir();
                break;
            case 3: 
                depositarValor();
                exibir();
                break;
            case 4:
                sacarValor();
                exibir();
                break;
            case 5:
                transferirValor();
                exibir();
                break;
            case 6:
                cadastrarCliente();
                exibir();
                break;
            case 7:
                abrirConta();
                exibir();
                break;
            case 8:
                listarClientes();
                exibir();
                break;
            case 9:
                System.out.println("Obrigado por utilizar nosso sistema!");
                System.out.println("Tenha um bom dia!");
                break;
        }
    }

    private static void listarClientes() {
        System.out.println("==== Lista clientes cadastrados");
        System.out.println("Número\t|\tNome");
        for (Entry<Integer, Cliente> clientes : clientes.entrySet()) {
            System.out.printf("%d\t|\t%s\n", clientes.getKey(), clientes.getValue().getNome());
        }
        System.out.println();
    }


    private static void cadastrarCliente() {
        System.out.print("Insira o nome do cliente: ");
        String nome = input.nextLine();
        clientes.put(SEQUENCIAL++, new Cliente(nome));        
        exibir();
    }


    private static void abrirConta() {
        System.out.println("Informe o tipo de conta que deseja abrir: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");

        int opcaoDesejada=0;
        
        try{
            opcaoDesejada = input.nextInt();
            input.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Por favor, insira um valor válido!");
        }     
        
        switch(opcaoDesejada){
            case 1:
                System.out.println("==== Cadastro de conta corrente ====");
                System.out.print("Digite o número do cliente: ");
                int numeroCliente = input.nextInt();
                input.nextLine();
                contas.add(new ContaCorrente(clientes.get(numeroCliente)));
                System.out.println("Conta criada com sucesso!");
                break;
            case 2: 
                System.out.println("==== Cadastro de conta poupança ====");
                System.out.print("Digite o número do cliente: ");
                numeroCliente = input.nextInt();
                input.nextLine();
                contas.add(new ContaPoupanca(clientes.get(numeroCliente)));
                System.out.println("Conta criada com sucesso!");
                break;
            default:
                System.out.println("Insira um valor válido!");
                abrirConta();
        }

    }


    private static void transferirValor() {
    
    
    }


    private static void sacarValor() {
    }


    private static void depositarValor() {
    }


    private static void listarContas() {
        System.out.println("==== Lista clientes cadastrados");
        System.out.println("Agencia\t|\tNumero\t|\tSaldo\t|\tCliente\t|\tTipo de Conta");
        for (Conta conta : contas) {
            System.out.println(conta.toString());
        }
        System.out.println();

    }


    private static void exibirExtrato() {
    }
    
    



}
