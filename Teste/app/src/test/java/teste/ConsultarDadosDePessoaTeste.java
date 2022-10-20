package teste;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsultarDadosDePessoaTeste {
    
    @BeforeAll //realiza antes de tudo
    static void configuraConexao(){
        GerenciadorConexaoDB.iniciarConexao();
    }

    @BeforeEach //realiza antes de cada teste
    void insereDadosParaTeste(){
        GerenciadorConexaoDB.insereDados(new Pessoa("João", LocalDate.of(1997, 06, 17)));
    }

    @AfterEach //realiza apos cada teste
    void removeDadosParaTeste(){
        GerenciadorConexaoDB.RemoveDados(new Pessoa("João", LocalDate.of(1997, 06, 17)));
    }
    
    @Test
    void validarDadosDeRetorno(){
        Assertions.assertTrue(true);
    }

    @Test
    void validarInsercao(){
        Assertions.assertNull(null);
    }

    @AfterAll //realiza apos todos os testes
    static void finalizarConexao(){
        GerenciadorConexaoDB.finalizarConexao();
    }


/* O OUTPUT DO DEBUG CONSOLE ABAIXO MOSTRA QUE BeforeEach E AfterEach OCORREM ENTRE OS TESTES
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB iniciarConexao
INFO: Iniciou conexão!
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB insereDados
INFO: Inseriu dados! ---> AQUI
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB RemoveDados
INFO: Removeu dados! ---> AQUI
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB insereDados
INFO: Inseriu dados! ---> AQUI
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB RemoveDados
INFO: Removeu dados! ---> AQUI
Oct 20, 2022 6:06:12 PM teste.GerenciadorConexaoDB finalizarConexao
INFO: Finalizou conexão! */



}
