package DIO_bootcamp.Metodos.metodosJavaAula1.src.primeiraAula;

public class Emprestimo {
    public static void calcular(double valor, int parcela){

        double taxa = parcela*0.1;

        double valorFinal = valor * (1+taxa);
        double valorPorParcela = valorFinal/parcela;

        System.out.printf("Valor final do empréstimo para %d parcelas: R$ %.2f\n", parcela, valorFinal);
        System.out.printf("O valor de cada parcela será: %d X R$ %.2f\n\n", parcela, valorPorParcela);
        
    }
}
