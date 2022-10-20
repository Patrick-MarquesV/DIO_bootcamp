package DIO_bootcamp.Metodos.metodosJavaAula3_retorno.src.aula3Retornos;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Cálculo área qualidrateros notáveis:");
        System.out.println("Área do quadrado: " + Quadrilatero.area(3));
        System.out.println("Área do retângulo: " + Quadrilatero.area(5d, 5d));
        System.out.println("Área do trapézio: "+ Quadrilatero.area(7, 8, 9));
        System.out.println("Área do losângo: " + Quadrilatero.area(5f, 5f));
   }
}