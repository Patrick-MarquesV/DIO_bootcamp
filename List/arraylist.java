package DIO_bootcamp.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class arraylist {
    public static void main(String[] args) {
     
        List<Integer> notas = new ArrayList<>();

        for (int i = 0; i < 10  ; i++) {
            notas.add(i); //adiciona valor na ultima posição
        }

        System.out.println(notas); //imprime a lista toda
        System.out.println(Collections.min(notas)); //valor minimo
        System.out.println(Collections.max(notas)); //valor maximo
        System.out.println(notas.get(5)); //exibe valor dado a posição
        
        Iterator<Integer> iterator = notas.iterator(); //inicia um iterador dos elementos contidos na lista

        int sum = 0;

        while(iterator.hasNext()){ //verifica se existe proximo
            Integer next = iterator.next(); //armazena valor atual do iterador
            sum+=next; //soma todos elementos da lista
        }

        System.out.println(sum);

        System.out.println((double)sum/notas.size()); //da o tamanho, equivale ao length de array e string

        notas.remove(5); //remove um elemento dada a posição ou o objeto

        Iterator<Integer> iterator1 = notas.iterator();

        while(iterator1.hasNext()){
            Integer next = iterator1.next();

            if(next<7) iterator1.remove(); //remove item atual

        }

        System.out.println(notas);
        System.out.println(notas.size());

        notas.clear(); //apaga toda a lista

        System.out.println(notas.isEmpty()); //verifica se esta vazia

    }

}
