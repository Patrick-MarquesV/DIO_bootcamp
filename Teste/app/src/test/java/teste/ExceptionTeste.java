package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTeste {

    @Test
    void validaTransferenciaEntreContas(){
        Conta contaOrigem = new Conta("12345", 0);
        Conta contaDestino = new Conta("12346", 100);
        
        TransferenciaEntreContas novaTransf = new TransferenciaEntreContas();

        // Assertions.assertDoesNotThrow(); //verifica se nao vai dar exceção
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
        novaTransf.transfere(contaOrigem, contaDestino, -1)); //VERIFICA SE LANÇOU A EXCEÇÂO CORRETAMENTE
    }   


}
