package teste;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*; //Dessa forma podemos acessar os metodos da coleção Assertions diretamente


public class assertionsTeste {
    
    @Test
    void validaLancamentos(){

        int [] primeiroLancamento = {10, 20, 30, 40, 50};
        int [] segundoLancamento = {-1, 5, 2, 3, 10};

        Assertions.assertArrayEquals(primeiroLancamento, segundoLancamento); // Compara se os arrays são iguais

        //Assertions.assertNotEquals(primeiroLancamento, segundoLancamento); // Compara se os arrays são diferentes

    }

    @Test
    void validarSeObjetoEstaNulo(){

        Pessoa karina = null;

        Assertions.assertNull(karina); //verifica se o objeto é null
        
        karina = new Pessoa("Karina", LocalDate.now());
        
        Assertions.assertNotNull(karina); //verifica se o objeto não é null
 
    }

    @Test
    void validarNumerosDeTiposDiferentes(){

        double valor = 5.0;
        double outroValor = 5.0;

        Assertions.assertEquals(valor, outroValor);


    }


}
