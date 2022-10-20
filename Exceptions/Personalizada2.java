package DIO_bootcamp.Exceptions;

import javax.swing.JOptionPane;

public class Personalizada2 {
        public static void main(String[] args) {
            
            int[] numerador = {4, 5, 8, 10, 20};
            int[] denominador = {2, 4, 0, 2, 8};

            for (int i = 0; i < denominador.length; i++) {
                try{      
                    if(numerador[i]%2!=0) 
                        throw new DivisaoNaoExata("Disão não exata!", numerador[i], denominador[i]);
 
                    int resultado = numerador[i]/denominador[i];
                    
                    System.out.println(resultado);
                } catch(DivisaoNaoExata e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", i);
                } catch(ArrayIndexOutOfBoundsException e){
                    JOptionPane.showMessageDialog(null, "A quantidade de elementos das duas arrays devem ser iguais!" + e.getMessage(), "ERRO", 0);
                } catch(ArithmeticException e){
                    JOptionPane.showMessageDialog(null, "Não é possível dividir por zero!" + e.getMessage(), "ERRO", 0);    
                }
            };                
                
            System.out.println("O programa continua...");

        }

        //TRATANDO A DIVISÃO NÃO EXATA


}

class DivisaoNaoExata extends Exception{

    private int numerador;
    private int denominador;

    public DivisaoNaoExata(String message, int numerador, int denominador) {
        super(message);
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
}
