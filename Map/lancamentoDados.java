package DIO_bootcamp.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class lancamentoDados {
    public static void main(String[] args) {
        
        Map<Integer, Integer> lancamentoDados = new HashMap<>();
        
        Random generator = new Random();

        for (int i = 1; i <= 100; i++) {
            int aleatorio = generator.nextInt(6) + 1;
            lancamentoDados.put(i, aleatorio);
        }

        Set<Entry<Integer, Integer>> entrySet = lancamentoDados.entrySet();

        for (int i = 1; i <= 100; i++) {
            int contador = 0;
            for (Entry<Integer,Integer> lancamento : entrySet) {
                if(i == lancamento.getValue()) contador++;
            }
            if(contador > 0) System.out.println("Numero " + i + " - Lançado " + contador + " Vezes");
        }

    }
}
