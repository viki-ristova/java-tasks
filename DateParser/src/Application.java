import java.util.Scanner;

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
