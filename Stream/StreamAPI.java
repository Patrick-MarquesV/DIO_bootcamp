package DIO_bootcamp.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("==============================================================================");

        System.out.println("Imprima todos os elementos dessa lista: ");

        System.out.println("Usando Lambda: ");
        numerosAleatorios.stream().forEach(numero -> System.out.println(numero));

        System.out.println("Usando reference method: ");
        numerosAleatorios.stream().forEach(System.out::println);

        System.out.println("==============================================================================");

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");

        numerosAleatorios.stream()
            .limit(5)
            .collect(Collectors.toSet())
            .forEach(System.out::println);
        //imprimiu apenas 4 pois Set não permite repetição!

        System.out.println("==============================================================================");

        System.out.println("Transforme a lista de String em lista de números inteiros: ");

        List<Integer> numerosAletorios1 = numerosAleatorios.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        numerosAletorios1.forEach(System.out::println);
        
        System.out.println("==============================================================================");

        System.out.println("Imprima os numeros pares maiores que 2 e coloque numa lista: ");

        List<Integer> numerosAleatorios2 = numerosAleatorios.stream()
            .map(Integer::parseInt )
            .filter(i -> i%2==0 && i>2)
            .collect(Collectors.toList());

        numerosAleatorios2.forEach(System.out::println);

        System.out.println("==============================================================================");
        
        System.out.print("Exiba a média dos numeros da lista: ");
        
        numerosAleatorios.stream()
            .mapToInt(Integer::parseInt)
            .average()
            .ifPresent(System.out::println);


        System.out.println("==============================================================================");

        System.out.println("Remova os valores impares: ");
        
        List<Integer> numerosAleatorios3 = numerosAleatorios.stream()
         .map(Integer::parseInt)
         .collect(Collectors.toList());

         numerosAleatorios3.removeIf(i -> i%2==1);

         numerosAleatorios3.forEach(System.out::println);

         System.out.println("==============================================================================");


    }
}
