package DIO_bootcamp.Exceptions;

import java.io.*;

import javax.swing.JOptionPane;

//CHECKED EXCEPTIONS SÃO AQUELAS QUE SÃO OBRIGATÓRIAMENTE TRATADAS, 

public class Personalizada1 {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");

        imprimirArquivoNoConsole("DIO_bootcamp/Exceptions/"+nomeDoArquivo);      

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
        } catch(ImpossivelAberturaDeArquivoException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), nomeDoArquivo, 0);
            e.printStackTrace();
        } catch (IOException e){ //aqui é uma classe mais genérica que coleta os demais erros de leitura
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com o suporte! \n" + e.getMessage(), "Erro", 0);
            e.printStackTrace();
        } finally{
            System.out.println("Chegou no finally");
        }
    }

//CRIANDO EXCEPTION PERSONALIZADA:

    private static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException {
        File file = new File(nomeDoArquivo);
        
        try{
            return new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e){
            throw new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
        } 
    }
}

//Iniciando a exception através de uma classe que extende a classe Exception
class ImpossivelAberturaDeArquivoException extends Exception {

    private String nomeDoArquivo;
    private String diretorio;

    public ImpossivelAberturaDeArquivoException(String nomeDoArquivo, String diretorio) { //Gerando o construtor da exception
        super("O arquivo " + nomeDoArquivo + " não foi encontrado no diretório: " + diretorio);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorio = diretorio;
    }

    @Override
    public String toString() { //Sobrescrevendo o metodo toString
        return "ImpossivelAberturaDeArquivoException [nomeDoArquivo=" + nomeDoArquivo + ", diretorio=" + diretorio
                + "]";
    }

}
