package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @TestMethodOrder(MethodOrderer.MethodName.class) -- nesse caso ele respeita a ordem alfabetica do nome dos fluxos
// @TestMethodOrder(MethodOrderer.Random.class) -- nesse caso ele escolhe aleatóriamente
// @TestMethodOrder(MethodOrderer.DisplayName.class) -- nesse caso ele respeita o nome dado no display name abaixo
public class EscolhendoOrdemTeste {

    @DisplayName("A")
    @Order(4)
    @Test
    void validaFluxoA(){
        Assertions.assertTrue(true);
    }

    @DisplayName("B")
    @Order(3)
    @Test
    void validaFluxoB(){
        Assertions.assertTrue(true);    
    }

    @DisplayName("C")
    @Order(2)
    @Test
    void validaFluxoC(){
        Assertions.assertTrue(true);
    }

    @DisplayName("D")
    @Order(1)
    @Test
    void validaFluxoD(){
        Assertions.assertTrue(true);
    }




}
