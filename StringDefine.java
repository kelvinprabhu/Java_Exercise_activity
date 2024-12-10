import java.util.Comparator;

public class StringDefine implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // Implement comparison logic here
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        }
        return 0;
    }

}
