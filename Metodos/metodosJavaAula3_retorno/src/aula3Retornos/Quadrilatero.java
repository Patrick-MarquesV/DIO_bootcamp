package DIO_bootcamp.Metodos.metodosJavaAula3_retorno.src.aula3Retornos;

public class Quadrilatero {
    public static double area(double lado){

        return (lado*lado);

    }

    public static double area(double lado1, double lado2){
        
        return (lado1*lado2);

    }

    public static double area(double baseMaior, double baseMenor, double altura){

        return ((baseMaior+baseMenor)*altura)/2;

    }

    public static double area(float diagonalMenor, float diaginalMaior){

        return (diaginalMaior*diagonalMenor)/2;

    }
}