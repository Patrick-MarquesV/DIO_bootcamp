package Teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Main.Cliente;
import Main.Conta;
import Main.ContaCorrente;
import Main.ContaPoupanca;

public class TesteFuncoesConta {
    
    @Test
    void testaDeposito(){
        
        Conta novaConta = new ContaCorrente(new Cliente("Patrick"));

        novaConta.depositar(300);

        Assertions.assertEquals(300, novaConta.getSaldo()); 
    }

    @Test
    void testeSaque(){

        Conta novaConta = new ContaCorrente(new Cliente("Patrick"));

        novaConta.sacar(100);
        
        Assertions.assertEquals(0, novaConta.getSaldo());

        novaConta.depositar(300);  
        novaConta.sacar(200);

        Assertions.assertEquals(100, novaConta.getSaldo());

    }

    @Test
    void testeTransferencia(){

        Conta novaConta = new ContaCorrente(new Cliente("Patrick"));
        Conta contaDestino  = new ContaPoupanca(new Cliente("Patrick"));

        novaConta.transferir(100, contaDestino);

        Assertions.assertEquals(0, contaDestino.getSaldo());

        novaConta.depositar(400);

        novaConta.transferir(300, contaDestino);

        Assertions.assertEquals(100, novaConta.getSaldo());
        Assertions.assertEquals(300, contaDestino.getSaldo());

    }




}
