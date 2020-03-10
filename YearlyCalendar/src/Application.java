import java.util.ArrayList;
import java.util.Scanner;

/** Exercise: YearlyCalendar
 * An application class that for a given year entered by a user,
 * creates an array and there stores every day from January 1st to December 31st
 * represented as String element in the format "YYYY-MM-DD" and then prints out the array.
 * Note: Be careful for the leap years
 * Sample test input: 2020
 * Sample test output:
 * 2020-01-01
 * 2020-01-02
 *  ...
 * 2020-02-28
 * 2020-02-29
 * 2020-03-01
 *  ...
 * 2020-12-30
 * 2020-12-31
 */
public class Application {
    public static void main(String[] args) {
        int maxDaysInMonth = 0;
        System.out.println("Enter year:");
        Integer year = new Scanner(System.in).nextInt();
        //ArrayList<String> days = new ArrayList<>();
        String []days;
        if(year % 4 == 0) {
           days = new String[366];
        }
        else {
            days = new String[365];
        }
            int i = 0;

        for(int month = 1; month<13 ;month++) {

                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    maxDaysInMonth = 31;
                }
                else{
                    maxDaysInMonth = 30;
                    if (month == 2 && days.length == 366) {
                        maxDaysInMonth = 29;
                    }else if(month == 2 && days.length == 365){
                        maxDaysInMonth = 28;
                    }
                }
                for(int day = 1; day<=maxDaysInMonth;day++){
                    StringBuilder sb = new StringBuilder();
                    sb.append(year);
                    sb.append("-");
                    if(month<10 && month >0){
                        sb.append("0");
                    }
                    sb.append(month);
                    sb.append("-");
                    if(day<10 && day >0){
                        sb.append("0");
                    }
                    sb.append(day);
                    if(i==days.length){
                        break;
                    }
                    days[i]=sb.toString();
                i++;
                }
                if(i==days.length){
                    break;
                }
            }

        for(int j = 0; j < days.length;j++) {
            System.out.println(days[j]);
        }

    }
}
