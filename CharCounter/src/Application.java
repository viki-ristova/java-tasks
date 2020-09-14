import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/** Exercise: CharCounter; author: Viktorija Ristova
 * An application class that for a given sentence entered by a user,
 * counts and prints out the number of occurrences of each character in that sentence.
 *
 * Sample test input:
 * Input a sentence for character counting and press Enter:
 * "If the code does not execute, catch the exception and deal with it."
 *
 * Sample test output:
 * The number of occurrences of each character in the inserted sentence is shown below in key (characters), value (occurrences) pairs:
 * { =12, a=3, c=5, d=4, e=10, f=1, h=4, I=1, i=3, ,=1, l=1, n=3, .=1, o=4, p=1, s=1, t=8, u=1, w=1, x=2}
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Input a sentence for character counting and press Enter:");
        String sentence = new Scanner(System.in).nextLine();
        Map<Character, Integer> countCharacters = new HashMap<Character, Integer>();
        for (char c : sentence.toCharArray()) {
            int num = 0;
            if (!countCharacters.containsKey(c)) { //first time a character occurs
                countCharacters.put(c, 1);
            } else {
                num = countCharacters.get(c);
                countCharacters.put(c, ++num);
            }
            // countCharacters.merge(c, 1, Integer::sum);
        }
        System.out.println("The number of occurrences of each character in the inserted sentence is shown below in key (characters), value (occurrences) pairs: \n" + countCharacters);
    }
}