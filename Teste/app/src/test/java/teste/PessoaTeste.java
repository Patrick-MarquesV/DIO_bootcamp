package teste;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTeste {
    
    @Test
    void validarCalculoIdade(){

        Pessoa patrick = new Pessoa("Patrick", LocalDate.of(1997, 10, 21));  
        Assertions.assertEquals(24, patrick.getIdade());

    }

    @Test
    void validarEhMaiorDeIdade(){

        Pessoa patrick = new Pessoa("Patrick", LocalDate.of(1997, 10, 21));
        Assertions.assertTrue(patrick.ehMaiorDeIdade());

        Pessoa joao = new Pessoa("Joao", LocalDate.now());
        Assertions.assertFalse(joao.ehMaiorDeIdade());
    }


}
