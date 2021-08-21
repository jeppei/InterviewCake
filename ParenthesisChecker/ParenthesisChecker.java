package Projects.InterviewCake;

/**
 * Created by jesper on 2016-12-13.
 */
/**
 * Created by jesper on 2016-11-24.
 */
import java.util.*;

public class ParenthesisChecker{

    public static void main(String[] args) {
        String stringToCheck = "({D}[D]D<D{[G]3}2>)(((";
        System.out.println(check(stringToCheck));
    }

    public static boolean check(final String s) {
        HashSet<Character> startP = new HashSet<>(Arrays.asList('(', '[', '<', '{'));
        HashSet<Character> endP = new HashSet<>(Arrays.asList(')', ']', '}', '>'));
        HashMap<Character, Character> mapP = new HashMap<>();
        mapP.put('(', ')');
        mapP.put('<', '>');
        mapP.put('{', '}');
        mapP.put('[', ']');

        Stack<Character> stack = new Stack<>();
        int nonP = 0;

        for (char p: s.toCharArray()) {

            if (startP.contains(p)) {
                stack.push(p);
            } else if (endP.contains(p)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character start = stack.pop();
                if (!mapP.get(start).equals(p)) {
                    return false;
                }

            } else {
                nonP++;
            }


        }
        System.out.println("Number of non-parenthesis: " + nonP);
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
