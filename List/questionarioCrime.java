package DIO_bootcamp.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class questionarioCrime {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        List<String> respostas = new ArrayList<>();

        System.out.println("---\tQuestionário Policial\t---");
        System.out.println("1. Telefonu para a vítima? (S/N)");
        respostas.add(input.nextLine());
        System.out.println("2. Esteve no local do crime? (S/N)");
        respostas.add(input.nextLine());
        System.out.println("3. Mora perto da vítima? (S/N)");
        respostas.add(input.nextLine());
        System.out.println("4. Devia para a vítima? (S/N)");
        respostas.add(input.nextLine());
        System.out.println("5. Já trabalhou com a vítima? (S/N)");
        respostas.add(input.nextLine());

        Iterator<String> Iterator = respostas.iterator();

        while(Iterator.hasNext()){
            String next = Iterator.next();
            if(next.compareToIgnoreCase("S")!=0) Iterator.remove();
        }

        System.out.print("Classificado como: ");

        if(respostas.size()==2) System.out.println("Suspeita");
        else if(respostas.size()>=3 && respostas.size()<=4) System.out.println("Cúmplice");
        else if(respostas.size()==5) System.out.println("Assassina");
        else System.out.println("Inocente");
        
    }
}
