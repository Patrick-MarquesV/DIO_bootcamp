package DIO_bootcamp.Exceptions;

import java.io.*;

import javax.swing.JOptionPane;

//CHECKED EXCEPTIONS SÃO AQUELAS QUE SÃO OBRIGATÓRIAMENTE TRATADAS, 

public class Checked {
    public static void main(String[] args) {
        String nomeDoArquivo = "DIO_bootcamp/Exceptions/teste.txt";

        imprimirArquivoNoConsole(nomeDoArquivo);      

        System.out.println("O programa continua....");

    }

// O throws realiza o lançamento da Exception que precisará ser tratada na invocação do método
// Tambem é possivel tratar diretamente dentro do método com try-catch sem usar o throws

    private static void imprimirArquivoNoConsole(String nomeDoArquivo) { 
        
        try{ //Sempre colocar as Exception mais especificas primeiro
            
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
    
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
            do{
                bw.write(line);
                bw.newLine();
                line = br.readLine();
    
            } while(line != null);
        
            bw.flush();
            br.close();
        } catch (IOException e){ //aqui é uma classe mais genérica que coleta os demais erros de leitura
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com o suporte! \n" + e.getMessage(), "Erro", 0);
            e.printStackTrace();
        } finally{
            System.out.println("Chegou no finally");
        }
    }

    private static BufferedReader lerArquivo(String nomeDoArquivo) {
        File file = new File(nomeDoArquivo);

        try{
            return new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException e) { //aqui tratamos especificamente o erro onde o arquivo nao foi encontrado com o nome/caminho especificado
            JOptionPane.showMessageDialog(null, "Revise o nome do arquivo que deseja acessar! \n" + e.getMessage(), nomeDoArquivo, 0);
        }
        return null;
    }
}
