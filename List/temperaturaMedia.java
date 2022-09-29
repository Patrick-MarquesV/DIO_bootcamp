package DIO_bootcamp.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class temperaturaMedia {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Integer> temperatura = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            System.out.print("Insira a temperatura do mês " + (i+1) + ": ");
            temperatura.add(input.nextInt());
        }

        Iterator<Integer> iterator = temperatura.iterator();

        int average = 0;

        while(iterator.hasNext()){
            Integer next = iterator.next();
            average+=next;
        }

        average/=temperatura.size();

        System.out.println("A temperatura média desse período foi: "+average + "°C");
        System.out.println("Meses acima da média: ");

        for (int i = 0; i < temperatura.size(); i++) {
            if(temperatura.get(i)>average) System.out.println(getMes(i+1) + " - " + temperatura.get(i) + "°C");
        }

    }

    private static String getMes(int i) {
        
        switch(i){
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
        }       
        
        return null;
    }
}
