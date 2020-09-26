import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApplicationTest {

    @BeforeEach
    void setUp() {
    }

    /**Test for throwing an IllegalArgumentException when invalid value for order is provided**/
    @Test
    void filterAndSortWordsIllegalArgumentExceptionTest(){
        List<String> words = Arrays.asList("a","a","ab","abc");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Application.filterAndSortWords(words,"custom order",0,0),
                "Invalid value for ordering type.");
    }
    /** TESTS FOR THE SORT ORDER **/
    //taking all words (all elements of the list into account)
    //test for ascending order
    @Test
    void filterAndSortWordsAscendingAllWordsTest(){
        List<String> words = Arrays.asList("a","a","ab","abc");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"a",0,0);
        Assertions.assertEquals(Arrays.asList("a","ab","abc"),filteredAndSortedWords);
    }
    //taking all words (all elements of the list into account)
    //test for descending order
    @Test
    void filterAndSortWordsDescendingAllWordsTest(){
        List<String> words = Arrays.asList("a","a","ab","abc");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"d",0,0);
        Assertions.assertEquals(Arrays.asList("abc","ab","a"),filteredAndSortedWords);
    }
    /**TESTS FOR THE MIN AND MAX RANGE**/
    //testing min value with ascending order
    @Test
    void filterAndSortWordsAscendingOrderMinValue(){
        List<String> words = Arrays.asList("a","a","ab","abc","abcd","abcde");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"a",2,0);
        //should return all of the words from the list that are >= 2,because the value for max range provided is 0 ordered ascending
        Assertions.assertEquals(Arrays.asList("ab","abc","abcd","abcde"),filteredAndSortedWords);
    }
    //testing min value with descending order
    @Test
    void filterAndSortWordsDescendingOrderMinValue(){
        List<String> words = Arrays.asList("a","a","ab","abc","abcd","abcde");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"d",2,0);
        //should return all of the words from the list that are >= 2,because the value for max range provided is 0 ordered descending
        Assertions.assertEquals(Arrays.asList("abcde","abcd","abc","ab"),filteredAndSortedWords);
    }
    //testing max value with ascending order
    @Test
    void filterAndSortWordsAscendingOrderMaxValue(){
        List<String> words = Arrays.asList("a","a","ab","ab","abc","abcd","abcde","abcdef");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"a",0,4);
        //should return all of the words from the list that are <= 4,because the value for min range provided is 0 ordered ascending
        Assertions.assertEquals(Arrays.asList("a","ab","abc","abcd"),filteredAndSortedWords);
    }
    //testing max value with descending order
    @Test
    void filterAndSortWordsDescendingOrderMaxValue(){
        List<String> words = Arrays.asList("a","a","ab","ab","abc","abcd","abcde","abcdef");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"d",0,4);
        //should return all of the words from the list that are <= 4,because the value for min range provided is 0 ordered descending
        Assertions.assertEquals(Arrays.asList("abcd","abc","ab","a"),filteredAndSortedWords);
    }
    //testing min and max values together in combination with ascending order
    @Test
    void filterAndSortWordsAscendingOrderMinAndMaxRangeValue(){
        List<String> words = Arrays.asList("a","a","ab","ab","abc","abcd","abcde","abcdef");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"a",3,5);
        //should return all of the words from the list that are >=3 and <= 5,because the value for min range provided is 3, for max is 5 and the ordering is ascending
        Assertions.assertEquals(Arrays.asList("abc","abcd","abcde"),filteredAndSortedWords);
    }
    //testing min and max values together in combination with descending order
    @Test
    void filterAndSortWordsDescendingOrderMinAndMaxRangeValue(){
        List<String> words = Arrays.asList("a","a","ab","ab","abc","abcd","abcde","abcdef");
        List<String> filteredAndSortedWords = Application.filterAndSortWords(words,"d",3,5);
        //should return all of the words from the list that are >=3 and <= 5,because the value for min range provided is 3, for max is 5 and the ordering is descending
        Assertions.assertEquals(Arrays.asList("abcde","abcd","abc"),filteredAndSortedWords);
    }

    /**Tests for reading the file from file system**/
    @Test
    void loadWordsFromFileTest(){
        try {
            assertNotNull(Application.loadWordsFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }
}
