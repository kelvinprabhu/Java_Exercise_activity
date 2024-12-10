import java.util.Comparator;

public class CharDefine implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        char s1 = o1.charAt(0);
        char s2 = o2.charAt(0);
        // Implement comparison logic here

        if (s1 > s2) {
            return 1;
        } else if (s1 < s1) {
            return -1;
        }
        return 0;
    }

}
