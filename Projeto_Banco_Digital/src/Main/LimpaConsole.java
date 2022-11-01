package Main;

import java.io.IOException;

public class LimpaConsole {

    public static void limpar() throws IOException, InterruptedException{//Limpa a tela no windows, no linux e no MacOS

        if (System.getProperty("os.name").contains("Windows")) //verifica se o SO é windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033\143"); //Limpa console em MacOS e Linux
    }
}
