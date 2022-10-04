package DIO_bootcamp.Set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExLinguagem {
    public static void main(String[] args) {
        
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
            add(new LinguagemFavorita("C++", 1983, "VisualStudio"));
            add(new LinguagemFavorita("Python", 1991, "PyCharm"));
        }};

        System.out.println("Exiba a lista em ordem de inserção: ");

        for (LinguagemFavorita item : linguagens) {
            System.out.println(item);
        }

        System.out.println("=====================================================");

        System.out.println("Exiba a lista em ordem alfabetica por nome: ");
        
        Set<LinguagemFavorita> linguagens2 = new TreeSet<>(linguagens);

        for (LinguagemFavorita item : linguagens2) {
            System.out.println(item);
        }
        
        System.out.println("=====================================================");

        System.out.println("Exiba a lista em ordem alfabetica por IDE: ");

        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new comparatorIDE());

        linguagens3.addAll(linguagens2);

        for (LinguagemFavorita item : linguagens3) {
            System.out.println(item);
        }

        System.out.println("=====================================================");

        System.out.println("Exiba a lista em ordem numerica por ano de criação: ");

        Set<LinguagemFavorita> linguagens4 = new TreeSet<>(new comparatorAno());
        
        linguagens4.addAll(linguagens3);

        for (LinguagemFavorita item : linguagens4) {
            System.out.println(item);
        }

        System.out.println("=====================================================");

        System.out.println("Exiba a lista em ordem de ano de criação e nome: ");

        linguagens4 = new TreeSet<>(new comparatorAnoNome());
        linguagens4.addAll(linguagens3);

        for (LinguagemFavorita item : linguagens4) {
            System.out.println(item);
        }

        System.out.println("======================================");

        System.out.println("Exiba a lista em ordem de nome, ano de criação e IDE: ");

        linguagens4 = new TreeSet<>(new comparatorNomeAnoIde());
        linguagens4.addAll(linguagens3);
        linguagens4.add(new LinguagemFavorita("Python", 1991, "VSCode"));

        for (LinguagemFavorita item : linguagens4) {
            System.out.println(item);
        }

        System.out.println("======================================");

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private int anoDeCriacao;
    private String ide;
    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }
    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }
    public String getIde() {
        return ide;
    }
    public void setIde(String ide) {
        this.ide = ide;
    }
    @Override
    public String toString() {
        return "[nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
    }
    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.getNome().compareToIgnoreCase(linguagem.getNome());
    }


}

class comparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lingua1, LinguagemFavorita lingua2) {
        return lingua1.getIde().compareToIgnoreCase(lingua2.getIde());
    }

}

class comparatorAno implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lingua1, LinguagemFavorita lingua2) {
        return Integer.compare(lingua1.getAnoDeCriacao(), lingua2.getAnoDeCriacao());
    }

}

class comparatorAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lingua1, LinguagemFavorita lingua2) {
        
        int anoDeCriacao = Integer.compare(lingua1.getAnoDeCriacao(), lingua2.getAnoDeCriacao());

        if(anoDeCriacao != 0) return anoDeCriacao;

        int nome = lingua1.getNome().compareToIgnoreCase(lingua2.getNome());

        return nome;
    }


    
}

class comparatorNomeAnoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lingua1, LinguagemFavorita lingua2) {

        int nome = lingua1.getNome().compareToIgnoreCase(lingua2.getNome());

        if(nome != 0) return nome;

        int ano = Integer.compare(lingua1.getAnoDeCriacao(), lingua2.getAnoDeCriacao());

        if(ano != 0) return ano;

        int ide = lingua1.getIde().compareToIgnoreCase(lingua2.getIde());

        return ide;
    }



}