package DIO_bootcamp.Metodos.metodosJavaAula1.src.primeiraAula;

public class Mensagem {
    public static void obterMensagem(int hora){

        if(hora>23){
            mensagemHoraInvalida();
        } else if(hora >= 5 && hora <= 12){
            mensagemBomDia();
        } else if(hora > 12 && hora <=18){
            mensagemBoaTarde();
        } else{
            mensagemBoaNoite();
        }

    }

    public static void mensagemBomDia(){
        System.out.println("Bom dia!");
    }

    public static void mensagemBoaTarde(){
        System.out.println("Boa tarde!");
    }

    public static void mensagemBoaNoite(){
        System.out.println("Boa noite!");
    }
    
    public static void mensagemHoraInvalida(){
        System.out.println("Hora inválida!");
    }

}
