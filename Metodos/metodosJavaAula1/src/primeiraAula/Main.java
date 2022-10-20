package DIO_bootcamp.Metodos.metodosJavaAula1.src.primeiraAula;

public class Main {
    public static void main(String[] args){

        //Calculadora 
        System.out.println("Calculadora");
        Calculadora.soma(10, 15);
        Calculadora.subtracao(7, 2);
        Calculadora.divisao(9, 2);
        Calculadora.multiplicacao(6, 4);
        System.out.println();

        //Mensagem
        System.out.println("Mensagem");
        Mensagem.obterMensagem(14);
        Mensagem.obterMensagem(23);
        Mensagem.obterMensagem(7);
        System.out.println();

        //Empréstimo
        System.out.println("Empréstimo");
        Emprestimo.calcular(1000, 5);
        Emprestimo.calcular(5000, 10);
        Emprestimo.calcular(90000, 1);



    }
}
