package DIO_bootcamp.Metodos.metodosJavaAula2_Sobrecarga.src.exercicioSobrecargaQuadrilateros;

public class Quadrilatero {
    public static void area(double lado){

        System.out.printf("Área do quadrado: %.1f\n", (lado*lado));

    }

    public static void area(double lado1, double lado2){
        
        System.out.printf("Área do retângulo: %.1f\n", (lado1*lado2));

    }

    public static void area(double baseMaior, double baseMenor, double altura){

        System.out.printf("Área do trapézio: %.1f\n", ((baseMaior+baseMenor)*altura)/2);

    }

    public static void area(float diagonalMenor, float diaginalMaior){

        System.out.printf("Área do losângo: %.1f\n", (diaginalMaior*diagonalMenor)/2);

    }

    

}
