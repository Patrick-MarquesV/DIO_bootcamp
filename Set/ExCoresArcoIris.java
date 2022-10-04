package DIO_bootcamp.Set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExCoresArcoIris {
    public static void main(String[] args) {
        
        Set<ArcoIris> listaCores = new HashSet<>(){{
            add(new ArcoIris("Vermelho"));
            add(new ArcoIris("Amarelo"));
            add(new ArcoIris("Laranja"));
            add(new ArcoIris("Verde"));
            add(new ArcoIris("Azul"));
            add(new ArcoIris("Violeta"));
            add(new ArcoIris("Anil"));
        }};

        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        for (ArcoIris cor : listaCores) {
            System.out.println(cor); //imprime uma cor por linha
        }
        System.out.println("==========================================");

        System.out.print("Exiba o numero de cores: ");
        System.out.println(listaCores.size()); //mostra numero de cores 
        System.out.println("==========================================");

        System.out.println("Exiba as cores em ordem alfabetica: ");
        
        Set<ArcoIris> listaCores1 = new TreeSet<>(listaCores); //ordena em ordem alfabetica/natural usando o comparable e compareTo;
        
        for (ArcoIris cor : listaCores1) {
            System.out.println(cor);
        }
        System.out.println("==========================================");

        System.out.println("Exiba as cores em ordem inversa da que foi informada: ");
        Set<ArcoIris> listaCores2 = new LinkedHashSet<>(){{
            add(new ArcoIris("Vermelho"));
            add(new ArcoIris("Amarelo"));
            add(new ArcoIris("Laranja"));
            add(new ArcoIris("Verde"));
            add(new ArcoIris("Azul"));
            add(new ArcoIris("Violeta"));
            add(new ArcoIris("Anil"));
        }};

        List<ArcoIris> listaReversa = new LinkedList<>(listaCores2);

        Collections.reverse(listaReversa);

        for (ArcoIris cor : listaReversa) {
            System.out.println(cor);
        }
        System.out.println("==========================================");

        System.out.println("Exiba todas as cores que começam com a letra \"V\": ");
        
        Iterator<ArcoIris> iterator = listaCores2.iterator();

        while(iterator.hasNext()){
            ArcoIris next = iterator.next();

            if(next.getCor().startsWith("V")) System.out.println(next);
        }
        System.out.println("==========================================");

        System.out.println("Remova todas as cores que não começam com a letra \"V\": ");
        
        Iterator<ArcoIris> iterator2 = listaCores2.iterator();

        while(iterator2.hasNext()){
            ArcoIris next = iterator2.next();

            if(!next.getCor().startsWith("V")) iterator2.remove();
        }

        for (ArcoIris cor : listaCores2) {
            System.out.println(cor);
        }

        System.out.println("==========================================");

        //Limpe o conjunto
        listaCores2.clear();

        System.out.println("Confira se o conjunto está vazio: ");
        System.out.println("Set está vazio ? " + listaCores2.isEmpty());
        System.out.println("==========================================");

    }
}

class ArcoIris implements Comparable<ArcoIris> {

    private String cor;

    public ArcoIris(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "[cor=" + cor + "]";
    }

    @Override
    public int compareTo(ArcoIris cor) {
        return this.getCor().compareToIgnoreCase(cor.getCor());
    }
}


