package DIO_bootcamp.Set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class metodoSet {
    public static void main(String[] args) {
        
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6)); //incia o metodo Set
        System.out.println(notas); //primeiras observações, os elementos duplicados foram removidos, ficando apenas um numero 7 e a ordem de impressão é aleatória

        System.out.println("Contem nota 5?" + " " + notas.contains(5d)); //verifica se existe item.

        //esse tipo de lista não posui indice/posição.

        System.out.println("Menor nota? " + Collections.min(notas));
        System.out.println("Maior nota? " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();

        double sum = 0;

        while(iterator.hasNext()){
            double next = iterator.next();
            sum+=next;
        }

        System.out.println("Soma das notas é: " + sum);

        System.out.println("A media é: " + sum/notas.size());

        notas.remove(0d);

        System.out.println("removido a nota 0: " + notas);

        Iterator<Double> iterator1 = notas.iterator();

        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7) iterator1.remove();
        }

        System.out.println("Removido notas inferiores a 7: " + notas);

        ///////////////////////////////////////////////////////////////

        Set<Double> notas2 = new LinkedHashSet<>();

        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);

        System.out.println(notas2);

        Set<Double> notas3 = new TreeSet<>(notas2); //armazena os elementos em ordem natural autom  aticamente
        System.out.println(notas3);

        notas2.clear();
        System.out.println(notas2.isEmpty());


    }    
}
