package teste;

import java.util.logging.Logger;

public class GerenciadorConexaoDB {
    
    private static final Logger LOGGER = Logger.getLogger(GerenciadorConexaoDB.class.getName());

    public static void iniciarConexao(){
        //fez algo
        LOGGER.info("Iniciou conexão!");
    }

    public static void finalizarConexao(){
        //fez algo
        LOGGER.info("Finalizou conexão!");
    }

    public static void insereDados(Pessoa pessoa){
        //insere pessoa DB;
        LOGGER.info("Inseriu dados!");
    }

    public static void RemoveDados(Pessoa pessoa){
        //remove pessoa DB;
        LOGGER.info("Removeu dados!");
    }


}
