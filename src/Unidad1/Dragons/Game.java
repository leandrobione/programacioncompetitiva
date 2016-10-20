import java.util.*;

//http://codeforces.com/contest/230/A
public class Game {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        Player kito = new Player();
        kito.strength = s.nextInt();

        int dragons_count = s.nextInt();
        Dragon[] dragons = new Dragon[dragons_count];

        for (int i = 0; i < dragons_count; i++) {
            Dragon dragon = new Dragon();
            dragon.strength = s.nextInt();
            dragon.bonus = s.nextInt();
            dragons[i] = dragon;
        }

        Arrays.sort(dragons);

        for (int i = 0; i < dragons_count; i++) {
            if (kito.strength > dragons[i].strength) {
                kito.strength += dragons[i].bonus;
            }
            else {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }

    private static class Player {
        public Integer strength;
    }

    private static class Dragon implements Comparable<Dragon>{

        public Integer strength;
        public Integer bonus;

        @Override
        public int compareTo(Dragon dragon) {
            return strength.compareTo(dragon.strength);
        }
    }
}
