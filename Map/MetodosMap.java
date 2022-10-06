package DIO_bootcamp.Map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MetodosMap {
    public static void main(String[] args) {
    
        System.out.println("-------------------------------------------------------------");

        System.out.println("Crie um dicionario relacionando modelos e seus consumos: ");
        Map<String, Double> carrosPopulares  = new HashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("Gol", 15.2); //Como a chave Gol ja existe, sobrescreve o valor existente
        System.out.println(carrosPopulares);

        System.out.println("-------------------------------------------------------------");

        System.out.print("Confira se o modelo Tuckson está no dicionario: ");
        System.out.println(carrosPopulares.containsKey("Tuckson")); //verifica se existe a chave Tuckson em carrosPopulares 

        System.out.println("-------------------------------------------------------------");

        System.out.print("Exiba o consumo do Uno: ");
        System.out.println(carrosPopulares.get("Uno"));

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba o terceiro modelo adicionado: ");
        System.out.println("Em HashMap os valores são armazenos de forma aleatório, portanto isso não é possível");

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba os modelos: ");
        Set<String> keySet = carrosPopulares.keySet(); //esse metodo retorna um Set, por isso colamos numa variavel do tipo SET.
        System.out.println(keySet);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba o consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values(); //values() retorna uma Colletions, por isso o tipo de variavel
        System.out.println(consumos);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba o modelo mais econômico e o seu consumo: ");
        Double melhorConsumo = Collections.max(carrosPopulares.values());
        Set<Entry<String, Double>> entrySet = carrosPopulares.entrySet();
        String modeloMaisEconomico = "";
        for (Entry<String,Double> entry : entrySet) {
            if(entry.getValue().equals(melhorConsumo)){
                modeloMaisEconomico = entry.getKey();
                System.out.println("Modelo mais eficiênte: " + modeloMaisEconomico);
                System.out.println("Consumo: " + melhorConsumo + " km/l");
            }
        }

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba o modelo menos econômico e o seu consumo: ");
        Double piorConsumo = Collections.min(carrosPopulares.values());
        Set<Entry<String, Double>> entrySet2 = carrosPopulares.entrySet();
        String modeloMenosEconomico = "";
        for (Entry<String,Double> entry : entrySet2) {
            if(entry.getValue().equals(piorConsumo)){
                modeloMenosEconomico = entry.getKey();
                System.out.println("Modelo menos eficiênte: " + modeloMenosEconomico);
                System.out.println("Consumo: " + piorConsumo + " km/l");
            }
        }
        
        System.out.println("-------------------------------------------------------------");

        System.out.print("Exiba a soma dos consumos: ");

        Iterator<Double> iterator = carrosPopulares.values().iterator();

        Double somaConsumo = 0d;

        while(iterator.hasNext()){
            Double next = iterator.next();
            somaConsumo+=next;
        }

        System.out.println(somaConsumo);

        System.out.println("-------------------------------------------------------------");

        System.out.print("Exiba a média dos consumos dos carros listados: ");
        
        Double consumoMedio = somaConsumo/carrosPopulares.size();

        System.out.println(consumoMedio + " km/l");

        System.out.println("-------------------------------------------------------------");

        System.out.println("Remova todos os modelos com consumo de 15,6km/l: ");

        System.out.println("Antes = " + carrosPopulares);

        Iterator<Double> iterator2 = carrosPopulares.values().iterator();

        while(iterator2.hasNext()){
            if(iterator2.next().equals(15.6)) iterator2.remove();
        }   
        System.out.println("Depois  = " + carrosPopulares);

        System.out.println("-------------------------------------------------------------");

        System.out.println("Exiba todos os carros na ordem de implementação: ");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 15.6);
        }};

        System.out.println(carrosPopulares1);

        System.out.println("-------------------------------------------------------------");
        
        System.out.println("Exiba a lista de carros ordenado pelo modelo");

        System.out.println("Antes: " + carrosPopulares1);

        System.out.println("-------------------------------------------------------------");

        System.out.print(" Apague o dicionario de carros e exiba se está vazio: ");

        carrosPopulares1.clear();

        System.out.println(carrosPopulares1.isEmpty());

        System.out.println("-------------------------------------------------------------");


    }
}