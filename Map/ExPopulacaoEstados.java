package DIO_bootcamp.Map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ExPopulacaoEstados {
    public static void main(String[] args) {
    
        System.out.println("-------------------------------------------------------------");

        System.out.println("Crie um dicionário que relacione os Estados do NE com sua população: ");

        Map<String, Integer> populacaoEstadosNE = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);            
        }};

        System.out.println(populacaoEstadosNE);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Substitua a população RN por 3.534.165");

        populacaoEstadosNE.put("RN", 3534165);

        System.out.println(populacaoEstadosNE);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Confira se o estado da PB está no dicionario, caso negativo adicione com a população de 4.039.277");

        System.out.println("PB está no dicionário? " + populacaoEstadosNE.containsKey("PB"));

        if(!populacaoEstadosNE.containsKey("PB")) populacaoEstadosNE.put("PB", 4039277);

        System.out.println(populacaoEstadosNE);

        System.out.println("PB - " + populacaoEstadosNE.get("PB"));

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba os estados na ordem de inserção: ");

        Map<String, Integer> populacaoEstadosNE2 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);            
        }};

        System.out.println(populacaoEstadosNE2);
        
        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba os estados na ordem alfabetica: ");

        Map<String, Integer> populacaoEstadosNE3 = new TreeMap<>(populacaoEstadosNE);

        System.out.println(populacaoEstadosNE3);
        
        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba o estado com a menor população e sua quantidade: ");

        Integer menorPopulacao = Collections.min(populacaoEstadosNE3.values());

        Set<Entry<String, Integer>> entrySet = populacaoEstadosNE3.entrySet();

        for (Entry<String,Integer> estado : entrySet) {
            if(estado.getValue() == menorPopulacao) System.out.println(estado);
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba os estados com a maior população e sua quantidade: ");

        Integer maiorPopulacao = Collections.max(populacaoEstadosNE3.values());

        Set<Entry<String, Integer>> entrySet2 = populacaoEstadosNE3.entrySet();

        for (Entry<String,Integer> estado : entrySet2) {
            if(estado.getValue() == maiorPopulacao) System.out.println(estado);
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba a soma da população de todos os estados: ");

        int sum = 0;

        Iterator<Integer> iterator = populacaoEstadosNE3.values().iterator();

        while(iterator.hasNext()){
            sum+=iterator.next();
        }

        System.out.println("População total dos estados é: " + sum);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba a população media: ");

        System.out.println("A média é: " + sum/populacaoEstadosNE3.size());

        System.out.println("-------------------------------------------------------------");

        System.out.println("Remova os estados com população inferior a 4.000.000: ");

        Iterator<Integer> iterator2 = populacaoEstadosNE3.values().iterator();

        while(iterator2.hasNext()){
            if(iterator2.next()<4000000) iterator2.remove();
        }

        System.out.println(populacaoEstadosNE3);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Esvazie o dicionario e confirme que está vazio: ");

        populacaoEstadosNE3.clear();

        System.out.println("O dicionário está vazio? " + populacaoEstadosNE3.isEmpty());

        System.out.println("-------------------------------------------------------------");

        

    }
}