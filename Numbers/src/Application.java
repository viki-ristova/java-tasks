import java.util.Scanner;
/**
 * Exercise: Numbers
 * An application class that asks the user to enter a number of digits as words
 * and then prints them out as a single integer
 * Sample test input: Input number written digit by digit, each digit separated by a space, when you're done press Enter:
 * one five zero
 * Sample test output: 150
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Note: Type any digit for exit inserting\n Input number written digit by digit, each digit separated by a space, when you're done press Enter: ");
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() && !sc.hasNextInt()) {
            String number = sc.next();
            switch (number) {
                case "one":
                    System.out.print("1");
                    break;
                case "two":
                    System.out.print("2");
                    break;
                case "three":
                    System.out.print("3");
                    break;
                case "four":
                    System.out.print("4");
                    break;
                case "five":
                    System.out.print("5");
                    break;
                case "six":
                    System.out.print("6");
                    break;
                case "seven":
                    System.out.print("7");
                    break;
                case "eight":
                    System.out.print("8");
                    break;
                case "nine":
                    System.out.print("9");
                    break;
                case "zero":
                    System.out.print("0");
                    break;
                default:
                    System.out.println();

            }
            //sc.close();

        }
        }
    }

