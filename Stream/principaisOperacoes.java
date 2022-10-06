package DIO_bootcamp.Stream;

import java.util.*;

class principaisOperacoes{
    public static void main(String[] args) {

        System.out.println("#######################################################");
        System.out.println("Exiba em ordem aleatória: ");
        
        Map<Integer, Contato> agenda = new HashMap<>() {{
           put(1, new Contato("Simba", 5555));
           put(4, new Contato("Cami", 1111));
           put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("#######################################################");

        System.out.println("Exiba por ordem de inserção: ");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("#######################################################");

        System.out.println("Exiba por ordem de ID: ");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("#######################################################");

        //STREAM começa aqui na refatoração do código abaixo: 

        //======================== ANTES ===================================================
        // System.out.println("Exiba por ordem de número de telefone: ");
        // Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new ComparatorOrdemNumerica());
        // set.addAll(agenda.entrySet());
        // for (Map.Entry<Integer, Contato> entry: set) {
        //     System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
        //             ": " +entry.getValue().getNome());
        // }
        
        //======================== DEPOIS com classe anônima =================================

        // System.out.println("Exiba por ordem de número de telefone: ");
        // Set<Map.Entry<Integer, Contato>> set = new TreeSet<>( new Comparator<Map.Entry<Integer, Contato>>() {
        //     @Override
        //     public int compare(Entry<Integer, Contato> contato1, Entry<Integer, Contato> contato2) {
        //         return Integer.compare(contato1.getValue().getNumero(), contato2.getValue().getNumero());
        //     }
        // });

        //======================== DEPOIS com interface funcional do Comparator (comparing) =============

        // System.out.println("Exiba por ordem de número de telefone: ");
        // Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
        //     new Function<Map.Entry<Integer, Contato>, Integer>() {
        //         @Override
        //         public Integer apply(Entry<Integer, Contato> contato) {
        //             return contato.getValue().getNumero();
        //         }}
        
        // ));
    
        //======================== DEPOIS com função Lambda ===============================================

        System.out.println("Exiba por ordem de número de telefone: ");
        
        //Direto com função Lambda: 
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(contato -> contato.getValue().getNumero()));

        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " +entry.getValue().getNome());
        }

        System.out.println("#######################################################");

        System.out.println("Exiba por ordem de nome de contato: ");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(nomeContato -> nomeContato.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("#######################################################");

    }
}

class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}

//====== Substituido por classe anonima =================================================
// class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
//     @Override
//     public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//         return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
//     }
// }

//====== Substituido por função lambda =================================================
// class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
//     @Override
//     public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//         return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
//     }
// }