import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
/**
 * Exercise: WordSorterWithLambdaAndFilter; author: Viktorija Ristova
 * An application class that sorts and prints out all unique words from a "file.txt" in the root of the project dir.
 * * Note: The user should be able to specify the min and max length
 *  * of words that should be printed.
 *   ** Zero values for min and max should be ignored.
 *
 * Sample test input:
 * Please choose the order for sorting the words from the file...
 * For ascending order input a and press Enter, for descending order input d and press enter:
 * a
 * Please enter the minimum value for word length... and press enter
 * 2
 * Please enter the maximum value for word length... and press enter
 * 5
 *
 * Sample test output:
 The sorted list in ascending order:
 eu
 at
 in
 et
 id
 ac
 ex
 ut
 mi
 sit
 vel
 ...
 orci
 lorem
 ipsum
 ...
 risus
 Total unique words: 59

 *
 */
public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        String stringFile = FileUtils.readFileToString(file, "UTF-8");
        String strArr[] = stringFile.toLowerCase().split("\\s+");
        List<String> stringFileList = Arrays.asList(strArr);
        final int min, max;
        System.out.println("Please choose the order for sorting the words from the file...\n For ascending order input a and press Enter, for descending order input d and press enter:");
        String c = new Scanner(System.in).next();
        System.out.println("Please enter the minimum value for word length... and press enter");
        min = new Scanner(System.in).nextInt();
        System.out.println("Please enter the maximum value for word length... and press enter");
        max = new Scanner(System.in).nextInt();

        List<String> sortedWordsByLengthAsc = stringFileList.stream()
                .filter(ch -> c.equalsIgnoreCase("a"))
                .map(word -> word.replaceAll("[^a-z A-Z]", ""))
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .filter(x -> (max > 0) ? (x.length() >= min && x.length() <= max) : (x.length() >= min))
                .collect(Collectors.toList());

        List<String> sortedWordsByLengthDesc = stringFileList.stream()
                .filter(ch -> c.equalsIgnoreCase("d"))
                .map(word -> word.replaceAll("[^a-z A-Z]", ""))
                .distinct()
                .filter(x -> (max > 0) ? (x.length() >= min && x.length() <= max) : (x.length() >= min))
                .sorted(Comparator.comparingInt(String::length)
                        .reversed())
                .collect(Collectors.toList());

        if (c.equalsIgnoreCase("a")) {
            System.out.println("The sorted list in ascending order: ");
            sortedWordsByLengthAsc.stream().forEach(System.out::println);
            //System.out.println(sortedWordsByLengthAsc);
            System.out.println("Total unique words: " + sortedWordsByLengthAsc.size());
        } else if (c.equalsIgnoreCase("d")) {
            System.out.println("The sorted list in ascending order: ");
            sortedWordsByLengthDesc.stream().forEach(System.out::println);
            // System.out.println(sortedWordsByLengthDesc);
            System.out.println("Total unique words: " + sortedWordsByLengthDesc.size());
        }
    }
}