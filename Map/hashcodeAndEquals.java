package DIO_bootcamp.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class hashcodeAndEquals {
    
    public static void main(String[] args) {
        Collection produtos = new HashSet<>();
        
        System.out.println("##### Cadastro de produtos #####\n");
        
        try (Scanner entrada = new Scanner(System.in)) {
        String continuar = "s";
        while ("s".equalsIgnoreCase(continuar)) {
            System.out.print("SKU: ");
            String sku = entrada.nextLine();
    
            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            
            Produto produto = new Produto(sku, nome);
            if (produtos.contains(produto)) {
            System.err.println("Esse produto já foi adicionado. Utilize outro SKU!");
            } else {
            produtos.add(produto);
            System.out.println("Produto adicionado.");
            }
            
            System.out.print("Deseja adicionar mais algum produto? (s/n) ");
            
            continuar = entrada.nextLine();
        }
        }
        
        produtos.forEach(System.out::println);
    
        System.out.println("Fim");
    }
    
    
}

class Produto{

    private String sku;
    private String nome;
    public Produto(String sku, String nome) {
        this.sku = sku;
        this.nome = nome;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Produto [sku=" + sku + ", nome=" + nome + "]";
    }
    @Override
    public boolean equals(Object obj) {
        Produto outro = (Produto) obj;
        return this.sku.equals(outro.getSku());
    }
    @Override
    public int hashCode() {
        return this.sku.charAt(0);
    }

}