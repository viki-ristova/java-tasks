import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Exercise: WordSorter; author: Viktorija Ristova
 * An application class that prints out all unique words from a "file.txt" in the root of the project dir.
 *
 * Sample test input:
 * Please choose the order for sorting the words from the file...
 * For ascending order input a and press Enter, for descending order input d and press enter:
 * a
 *
 * Sample test output:
 * The sorted list in ascending order:
 * [a, ac, at, et, eu, ex, id, in, mi, ut, dui, est, hac, leo, nam, nec, non, sed, sem, sit, vel, amet, ante, arcu, cras, diam, duis, eget, elit, enim, erat, eros, nibh, nisi, nisl, nunc, odio, orci, quam, quis, urna, augue, dolor, donec, etiam, fusce, ipsum, justo, lacus, lorem, magna, massa, metus, neque, nulla, porta, proin, purus, risus, velit, aenean, auctor, congue, cursus, libero, luctus, mattis, mauris, mollis, nullam, ornare, platea, sapien, semper, tellus, tempor, tempus, tortor, turpis, varius, aliquam, aliquet, blandit, commodo, dapibus, egestas, euismod, feugiat, gravida, iaculis, integer, lacinia, laoreet, maximus, nuncsed, posuere, pretium, quisque, rhoncus, vivamus, accumsan, bibendum, dictumst, eleifend, faucibus, interdum, lobortis, maecenas, pharetra, praesent, sagittis, suscipit, vehicula, volutpat, antedonec, dignissim, efficitur, elementum, facilisis, fermentum, fringilla, habitasse, hendrerit, imperdiet, malesuada, phasellus, porttitor, tincidunt, tristique, ultricies, vulputate, adipiscing, vestibulum, condimentum, consectetur, liberoetiam, scelerisque, suspendisse, pellentesque, sollicitudin, metuspellentesque]
 * Total unique words: 141
 *
 */
public class Application {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        String stringFile = FileUtils.readFileToString(file, "UTF-8");
        stringFile = stringFile.replaceAll("[^a-z A-Z]", "");
        String strArr[] = stringFile.toLowerCase().split("\\s+");
        List<String> stringFileList = Arrays.asList(strArr);
        Set<String> uniqueWords = new TreeSet<>(stringFileList);
        // the requirement for uniqueness implies the usage of set as a suitable data structure, and in the focus of the exercise solving is a list of words, as specified in the directions
        stringFileList = new ArrayList<>(); //new list with the unique words
        stringFileList.addAll(uniqueWords);
        System.out.println("Please choose the order for sorting the words from the file...\n For ascending order input a and press Enter, for descending order input d and press enter:");
        String c = new Scanner(System.in).next();
        if (c.equalsIgnoreCase("a")) {
            Collections.sort(stringFileList, new AscendingLengthStringComparator());
            System.out.println("The sorted list in ascending order: ");
            System.out.println(stringFileList);
            System.out.println("Total unique words: " + stringFileList.size());
        } else if (c.equalsIgnoreCase("d")) {
            Collections.sort(stringFileList, new DescendingLengthStringComparator());
            System.out.println("The sorted list in descending order: ");
            System.out.println(stringFileList);
            System.out.println("Total unique words: " + stringFileList.size());
        } else
            System.out.println("Please, try again with making a choice by entering a / d. ");
    }
}
