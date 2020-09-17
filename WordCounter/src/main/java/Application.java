import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;
/** Exercise: WordCounter; author: Viktorija Ristova
 * An application class that counts the number of occurrences of words from "file.txt"
 * located in the root project directory.
 * The user gets them in the following format "<word> : <count>"
 * Sample test input:
 *  /
 *  *for the content from /file.txt
 * Sample test output:
 * The number of occurrences of words for the file.txt...
 * aenean : 1
 * elementum : 2
 * mollis : 2
 * efficitur : 2
 * tempor : 1
 * justo. : 1
 * ante, : 1
 * bibendum : 1
 * commodo : 3
 *
 *  . . .
 *
 */
public class Application  {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        String stringFile = FileUtils.readFileToString(file,"UTF-8");
        stringFile = stringFile.replaceAll("[^a-z A-Z]","");
        String strArr[] = stringFile.toLowerCase().split("\\s+");
        Map<String, Integer> countWords = new HashMap<>();
        List<String> stringFileList = Arrays.asList(strArr);
        for (String word : stringFileList) {
            int num = 0;
            if (!countWords.containsKey(word)) { //first time a word occurs
                countWords.put(word, 1);
            } else {
                num = countWords.get(word);
                countWords.put(word, ++num);
            }
        }
        //System.out.print(countWords);
        System.out.println("The number of occurrences of words for the file.txt...");
        countWords.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

}
