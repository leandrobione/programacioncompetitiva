import java.util.*;

//https://omegaup.com/arena/problem/simbolos#problems
public class Main {
    
    protected static Character matching(Character c) {
        switch (c) {
            case ')':
                    return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return c;
    }
    
    protected static Boolean isOpening(Character c) {
        if (c == '(' || c == '[' || c == '{' ) {
            return true;
        }
        return false;
    }
    
    protected static Boolean isClosing(Character c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        Stack<Character> q = new Stack<Character>();
        Stack<Integer> p = new Stack<Integer>();
        int position = 0;
        
        for (int i = 0; i < line.length(); i++) {            
            if (isOpening(line.charAt(i))) {
                q.add(line.charAt(i));
                p.add(i);
            }
            else if (isClosing(line.charAt(i))) {
                
                if (q.size() == 0) {
                    System.out.println(i + 1); //No open Symbol
                    System.exit(0);
                }
                
                Character lastOpen = q.pop();
                position = p.pop();
                Character Symbol = matching(line.charAt(i));
                    
                if (lastOpen != Symbol) {                    
                    for (int j = i + 1; j < line.length(); j++) {                                                  
                        if (isClosing(line.charAt(j))) {
                            if (lastOpen == matching(line.charAt(j))) { //Overlaping, error on i
                                System.out.println(i + 1);
                                System.exit(0);
                            }                           
                        }
                    }                                                            
                    System.out.println(i + 1); //Nothing else, error on p, not closing match
                    System.exit(0);
                }              
            }
        }
        
        if (q.size() == 0) {
            System.out.println(0); //All matched no problem.
        }
        else {
            System.out.println(p.firstElement() + 1); //Open without a match
        }
    }            
}
    