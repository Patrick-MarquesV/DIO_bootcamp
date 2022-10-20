package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTeste {

    @Test //Uma Assmption falsa aborta o teste e não falha
    void validarAlgoSomenteNoUsuarioPatrick(){
        Assumptions.assumeTrue("patrick".equals(System.getenv("USER")));
        Assertions.assertEquals(10, 5+5);
    }
    

}
