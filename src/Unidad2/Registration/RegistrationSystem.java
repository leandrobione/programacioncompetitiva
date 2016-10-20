import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RegistrationSystem {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cantString = scanner.nextInt();

        HashMap<String, Integer> mapaValores = new HashMap<String, Integer>();

        for (int i = 0; i < cantString; i++) {
            String actual = scanner.next();

            Integer cantOcurrencias = mapaValores.get(actual);
            if (cantOcurrencias == null){
                System.out.println("OK");
                mapaValores.put(actual, 1);
            } else {
                System.out.println(actual+cantOcurrencias);
                cantOcurrencias+=1;
                mapaValores.put(actual, cantOcurrencias);
            }
        }
    }
}
