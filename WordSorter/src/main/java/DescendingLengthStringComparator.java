import java.util.Comparator;

public class DescendingLengthStringComparator implements Comparator<String> {


    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length())
            return 0;
        else if (s1.length() < s2.length())
            return 1;
        else
            return -1;
    }
}
