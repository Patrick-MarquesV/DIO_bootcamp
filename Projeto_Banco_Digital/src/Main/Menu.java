package Main;

import java.io.IOException;
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

    public static void exibir(){
        try {
            LimpaConsole.limpar();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
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
        System.out.print("Digite a opção desejada: ");
        int opcaoDesejada = leValorInteiro();

        
        return opcaoDesejada;
        
    }
    
    private static void avaliaEntrada(int entrada) {
        switch (entrada) {
            case 1:
                exibirExtrato();
                pressEnterToContinue();
                break;
            case 2:
                listarContas();
                pressEnterToContinue();
                break;
            case 3:
                depositarValor();
                pressEnterToContinue();
                break;
            case 4:
                sacarValor();
                pressEnterToContinue();
                break;
            case 5:
                transferirValor();
                pressEnterToContinue();
                break;
            case 6:
                cadastrarCliente();
                pressEnterToContinue();
                exibir();
                break;
            case 7:
                abrirConta();
                pressEnterToContinue();
                break;
            case 8:
                listarClientes();
                pressEnterToContinue();
                break;
            case 9:
                System.out.println("Obrigado por utilizar nosso sistema!");
                System.out.println("Tenha um bom dia!");
                break;
            default:
                System.out.println("Opção inválida, por favor, tente novamente!");
                pressEnterToContinue();
        }

    }

    private static void listarClientes() {
        System.out.println("==== Lista clientes cadastrados");
        System.out.printf("%-10s\t|\t%-10s\n", "Número", "Nome");
        for (Entry<Integer, Cliente> clientes : clientes.entrySet()) {
            System.out.printf("%-10d\t|\t%-10s\n", clientes.getKey(), clientes.getValue().getNome());
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
        System.out.println("3 - Voltar");
        int opcaoDesejada=leValorInteiro();
        
        switch(opcaoDesejada){
            case 1:
                System.out.println("==== Cadastro de conta corrente ====");
                System.out.print("Digite o número do cliente: ");

                int numeroCliente = leValorInteiro();

                contas.add(new ContaCorrente(clientes.get(numeroCliente)));

                System.out.println("Conta criada com sucesso!");
                break;
            case 2: 
                System.out.println("==== Cadastro de conta poupança ====");
                System.out.print("Digite o número do cliente: ");

                numeroCliente = leValorInteiro();

                contas.add(new ContaPoupanca(clientes.get(numeroCliente)));

                System.out.println("Conta criada com sucesso!");
                break;
            case 3:
                break;
            default:
                System.out.println("Insira um valor válido!");
                abrirConta();
        }

    }


    private static void transferirValor() {
        
        System.out.println("==== Transferência ====");
                
        System.out.println("Insira o numero da sua conta: ");

        int contaOrigem = leValorInteiro()-1;

        System.out.println("Insira o valor a ser transferido: ");

        int valor = leValorInteiro();

        System.out.println("Insira o numero da conta destino: ");

        int contaDestino = leValorInteiro()-1;

        contas.get(contaOrigem).transferir(valor, contas.get(contaDestino));
    }


    private static void sacarValor() {
        System.out.println("==== Sacar Valor ====");    
        System.out.print("Digite o numero da conta: ");

        int numeroConta = leValorInteiro()-1;

        System.out.print("Digite o valor a ser sacado: ");

        int valor = leValorInteiro();

        contas.get(numeroConta).sacar(valor);

    }

    private static void depositarValor() {
        System.out.println("==== Depositar Valor ====");
        System.out.print("Digite o numero da conta: ");

        int numeroConta = leValorInteiro()-1;

        System.out.print("Digite o valor a ser depositado: ");

        int valor = leValorInteiro();

        contas.get(numeroConta).depositar(valor);
    }

    private static void listarContas() {
        System.out.println("==== Lista clientes cadastrados");
        System.out.printf("%-10s\t|\t%-10s\t|\t%-10s\t|\t%-10s\t|\t%-10s\n","Agencia", "Numero", "Saldo", "Cliente", "Tipo de Conta");
        for (Conta conta : contas) {
            System.out.println(conta.toString());
        }
        System.out.println();

    }

    private static void exibirExtrato() {



    }

    private static void pressEnterToContinue()
    {
        System.out.println("Pressione Enter para continuar...");
        try
        {
            System.in.read();
            input.nextLine();
        } catch(Exception e)
        {
            System.out.println("Algo deu errado!");
        }
    }

    private static int leValorInteiro(){

        int valor=0;

        try{
            valor = input.nextInt();
            input.nextLine();
        } catch(InputMismatchException e){
            System.out.println("Por favor, insira um valor válido!");
            input.nextLine();
        }

        return valor;

    }

}
