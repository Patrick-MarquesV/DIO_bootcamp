package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class CondicionaisTeste {
    
    @Test //Semelhante ao Assumption o condicional tambem aborta, mas possui estrutura diferente
    @EnabledIfEnvironmentVariable(named = "USER", matches = "patrick") //habilita teste caso o usuario esteja correto
    void validarAlgoSomenteNoUsuarioPatrick(){
        Assertions.assertEquals(10, 5+5);
    }

    @Test //Semelhante ao Assumption o condicional tambem aborta, mas possui estrutura diferente
    @DisabledIfEnvironmentVariable(named = "USER", matches = "patrick")//desbilita teste caso o usuario esteja correto
    void validarAlgoSomenteNoUsuario(){
        Assertions.assertEquals(10, 5+5);
    }

    @Test //Semelhante ao Assumption o condicional tambem aborta, mas possui estrutura diferente
    @EnabledOnOs({OS.LINUX, OS.WINDOWS}) //Habilita caso o OS esteja conforme especificado
    void validarAlgoSomenteNoUsuario2(){
        Assertions.assertEquals(10, 5+5);
    }
    @Test //Semelhante ao Assumption o condicional tambem aborta, mas possui estrutura diferente
    // @EnabledOnJre(JRE.JAVA_8) //Habilita caso o versao do java esteja conforme especificado
    @EnabledForJreRange(min = JRE.JAVA_11,  max = JRE.JAVA_17)
    void validarAlgoSomenteNoUsuario3(){
        Assertions.assertEquals(10, 5+5);
    }


}
