import java.util.Scanner;
/** Exercise: Address; author: Viktorija Ristova
 * An application class that for four fields (street, streetNumber, city and zipCode) entered by a user,
 * creates an instance of the Address class and prints out the full address.
 * Note: The number given for the zip code must be 5 or 9 digits long. (In this case the user gets the printed out address as output.)
 *  if that is not the case, the zip code is considered as invalid,
 *    and a custom exception InvalidZipCodeException is thrown and caught. (In this case the user gets a message that the zip code is invalid, and the exception stacktrace).
 *
 * Sample test input 1:
 * Please input the fields necessary for address information...
 * Insert the name of the street and press Enter:
 * Dramska
 * Input the street number and press enter:
 * 26
 * Enter the name of the city and press enter:
 * Skopje
 * Input the zip code number and press enter -
 * 1000
 *
 * Sample test output 1:
 * InvalidZipCodeException: The zip code is invalid. It should consist 5 or 9 digits.
 * 	at Address.<init>(Address.java:18)
 * 	at Application.main(Application.java:29)
 *
 * 	Sample test input 2:
 * 	Please input the fields necessary for address information...
 * Insert the name of the street and press Enter:
 * Dramska
 * Input the street number and press enter:
 * 26
 * Enter the name of the city and press enter:
 * Skopje
 * Input the zip code number and press enter -
 * 100000000
 *
 * Sample test output 2:
 * Address{street='Dramska', streetNumber=26, city='Skopje', zipCode=100000000}
 *
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Please input the fields necessary for address information... ");
        System.out.println("Insert the name of the street and press Enter: ");
        String street = new Scanner(System.in).nextLine();
        System.out.println("Input the street number and press enter: ");
        Integer streetNumber = new Scanner(System.in).nextInt();
        System.out.println("Enter the name of the city and press enter: ");
        String city = new Scanner(System.in).nextLine();
        System.out.println("Input the zip code number and press enter - ");
        Integer zipCode = new Scanner(System.in).nextInt();
        try {
            Address address = new Address(street, streetNumber, city, zipCode);
            System.out.println(address);
        } catch (InvalidZipCodeException e) {
            e.printStackTrace();
        }
    }
}
