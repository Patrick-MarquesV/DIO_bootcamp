package DIO_bootcamp.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class ordenacaoMap {
    public static void main(String[] args) {
        
        System.out.println("-------------------------------------------------------------");

        System.out.println("Ordem aleatória, exibindo nome do autor e nome do livro: ");

        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));
        }};

        for(Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey());
            System.out.println(livro.getValue().getNome());
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Ordem de inserção, exibindo apenas autor e nome: ");

        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));
        }};

        for(Entry<String, Livro> livro : meusLivros1.entrySet()){
            System.out.println(livro.getKey());
            System.out.println(livro.getValue().getNome());
        }

        System.out.println();

        System.out.println("-------------------------------------------------------------");

        System.out.println("Ordem alfabética Autores: ");

        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1); //Ordena naturalmente pela chave (Autores)

        for(Entry<String, Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey());
            System.out.println(livro.getValue().getNome());
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Ordem alfabética Nome: ");

        Set<Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());

        meusLivros3.addAll(meusLivros2.entrySet());

        for (Entry<String,Livro> livro : meusLivros3) {
            System.out.println(livro.getKey());
            System.out.println(livro.getValue().getNome());
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Ordem numerica de páginas");
        
        Set<Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());

        meusLivros4.addAll(meusLivros2.entrySet());

        for (Entry<String,Livro> livro : meusLivros4) {
            System.out.println(livro.getKey());
            System.out.println(livro.getValue().getNome() + " - Páginas: " + livro.getValue().getPagina());
        }

        System.out.println("-------------------------------------------------------------");

    }
}

class Livro {

    private String nome;
    private int pagina;
    public Livro(String nome, int pagina) {
        this.nome = nome;
        this.pagina = pagina;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPagina() {
        return pagina;
    }
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + pagina;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (pagina != other.pagina)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "[nome=" + nome + ", pagina=" + pagina + "]";
    }

}

class ComparatorNome implements Comparator<Entry<String, Livro>>{
    @Override
    public int compare(Entry<String, Livro> livro1, Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }

}

class ComparatorPagina implements Comparator<Entry<String, Livro>>{

    @Override
    public int compare(Entry<String, Livro> livro1, Entry<String, Livro> livro2) {
        return Integer.compare(livro1.getValue().getPagina(), livro2.getValue().getPagina());
    }

}