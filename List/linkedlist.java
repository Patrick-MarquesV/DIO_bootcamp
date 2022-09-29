package DIO_bootcamp.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class linkedlist {

    public static void main(String[] args) {
        
        List<Double> notas = new LinkedList<>();

        for (double i = 0; i < 20; i+=2) {
            notas.add(i);
        }

        System.out.println(notas);

        System.out.println(Collections.min(notas));
        System.out.println(Collections.max(notas));
        System.out.println(notas.get(4));

        Iterator<Double> iterator = notas.iterator();

        int sum = 0;

        while(iterator.hasNext()){
            Double next = iterator.next();
            sum+=next;
        }

        System.out.println(sum);

        System.out.println(sum/notas.size());

        notas.remove(10.0); //remove o elemento 10;
        System.out.println(notas);
        notas.remove(1); //remove o elemento que esta na posiçao 1
        System.out.println(notas);

        Iterator<Double> iterator2 = notas.iterator();

        while(iterator2.hasNext()){
            Double next = iterator2.next();
            if(next<7) iterator2.remove();
        }

        System.out.println(notas);
        System.out.println(notas.size());

        notas.clear();

        System.out.println(notas.isEmpty());

    }
}
