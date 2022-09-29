package DIO_bootcamp.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ordenacaoDeListas {
    public static void main(String[] args) {
        
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println(meusGatos); //exibe na ordem de inserção
    
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos); //exibe na ordem de aleatória

        Collections.sort(meusGatos); //ordena em ordem natural conforme inteface comparable e subinterface compareTo, onde indicamos o nome como criterio de ordenação
        System.out.println(meusGatos);

        //agora para fazer novas comparações sem alterar o compareTo precisamos inserir um comparator, para isso criamos uma nova classe ComparatorIdade

        meusGatos.sort(new ComparatorIdade()); //ordena por idade, ver classe CompartorIdade;
        System.out.println(meusGatos);
        
        meusGatos.sort(new ComparatorCor()); //ordena por cor, ver classe ComparatorCor;
        System.out.println(meusGatos);
        
        meusGatos.sort(new ComparatorNomeCorIdade()); //ordena por cor, ver classe ComparatorCor;
        System.out.println(meusGatos);
        
    }   

}

class Gato implements Comparable<Gato>{

    private String nome;
    private int idade;
    private String cor;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getCor(){
        return cor;
    }
    
    @Override
    public String toString(){
        return "{" + 
                "nome='" + nome + '\'' +
                ", idade=" + idade + 
                ", cor='" + cor + '\'' + '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }

}

class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        // TODO Auto-generated method stub
        return Integer.compare(gato1.getIdade(), gato2.getIdade());
    }

}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getCor().compareToIgnoreCase(gato2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato gato1, Gato gato2) {
        
        int nome = gato1.getNome().compareToIgnoreCase(gato2.getNome());

        if(nome != 0) return nome;

        int cor = gato1.getCor().compareToIgnoreCase(gato2.getCor());

        if(cor != 0) return cor;

        int idade = Integer.compare(gato1.getIdade(), gato2.getIdade());     
                
        return idade;
    }


}
