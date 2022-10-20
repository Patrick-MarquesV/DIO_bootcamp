package DIO_bootcamp.Exceptions;

import javax.swing.JOptionPane;

//UNCHECKED EXCEPTIONS SÃO AQUELAS QUE NÃO SÃO OBRIGATÓRIAMENTE TRATADAS, 
//CABE AO DESENVOLVEDO PREVE-LAS E FORNECER SEU TRATAMENTO PARA UM FUNCIONAMENTO CONFIÁVEL DO PROGRAMA

public class Unchecked{
    public static void main(String[] args) {
        
        boolean continueLooping = true;
        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado " + resultado);
                continueLooping = false;
            } catch(NumberFormatException e){
                
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage(), "Erro", 0);
                //e.printStackTrace(); //exibe pilha do erro que estourou

            } catch(ArithmeticException e){

                JOptionPane.showMessageDialog(null, "Impossível dividir um número por zero! " + e.getMessage(), "Erro", 0);
                
            } finally{
                System.out.println("Acionou o finally!!");
            }

        }while(continueLooping);

        System.out.println("O código continua..."); //mesmo dando erro, como ele foi tratado/captura, a execução do código continua!

    }

    private static int dividir(int a, int b) {
        return a/b;
    }

}