import java.util.Comparator;

public class Define implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // Implement comparison logic here
        if (o1 % 10 > o2 % 10) {
            return 1;
        } else if (o1 % 10 < o2 % 10) {
            return -1;
        }
        return 0;
    }
}
