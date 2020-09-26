import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> words = null;
        try {
            words = loadWordsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final int min, max;
        System.out.println("Please choose the order for sorting the words from the file...\n For ascending order input a and press Enter, for descending order input d and press enter:");
        String ordering = new Scanner(System.in).next();
        System.out.println("Please enter the minimum value for word length... and press enter");
        min = new Scanner(System.in).nextInt();
        System.out.println("Please enter the maximum value for word length... and press enter");
        max = new Scanner(System.in).nextInt();
        List<String> filteredAndSortedWords = filterAndSortWords(words, ordering, min, max);
        filteredAndSortedWords.stream().forEach(System.out::println);
        System.out.println("Total unique words: " + filteredAndSortedWords.size());
    }

    public static List<String> loadWordsFromFile() throws IOException {
        File file = new File("file.txt");
        String stringFile = FileUtils.readFileToString(file, "UTF-8");
        String[] strArr = stringFile.toLowerCase().split("\\s+");
        return Arrays.asList(strArr);
    }

    public static List<String> filterAndSortWords(List<String> words, String ordering, int min, int max) {
        List<String> sortedWordsByLength = words.stream()
                .map(word -> word.replaceAll("[^a-z A-Z]", ""))
                .distinct()
                .filter(x -> (max > 0) ? (x.length() >= min && x.length() <= max) : (x.length() >= min))
                .collect(Collectors.toList());

        if (ordering.equalsIgnoreCase("a")) {
            sortedWordsByLength.sort((w1, w2) -> w1.length() - w2.length());
        } else if (ordering.equalsIgnoreCase("d")) {
            sortedWordsByLength.sort((w1, w2) -> w2.length() - w1.length());
        } else if (!ordering.equalsIgnoreCase("a") && !ordering.equalsIgnoreCase("d")) {
            throw new IllegalArgumentException("Invalid value for ordering type.");
        }
        return sortedWordsByLength;
    }
}

