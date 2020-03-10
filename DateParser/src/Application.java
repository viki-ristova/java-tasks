import java.util.Scanner;
/**
 * Exercise: DateParser
 * An application class that reads a date in "MM/DD/YYYY" format
 * splits it into separate strings for month, day and year and prints them
 * Sample test input: 12/04/2007
 * Sample test output: Month: 12 Day: 04 Year: 2007
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Input date in MM/DD/YYYY and press Enter:");
        String str = new Scanner(System.in).nextLine();
        String month = str.substring(0,2);
        System.out.printf("Month: %s ", month );
        String day = str.substring(3,5);
        String year = str.substring(6,10);
        System.out.printf("Day: %s ", day );
        System.out.printf("Year: %s ", year);

    }
}
