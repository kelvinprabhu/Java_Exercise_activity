import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class collection_test {
    public static void main(String[] args) {
        Collection collection = new ArrayList<>();
        // Object val[] = new Object[6];
        // String val[] = new String[6];
        // val[0] = "neekfne";
        // val[1] = "knfnkewkf";
        // for (int i = 0; i < 2; i++) {
        // collection.add("anto");
        // }
        // Iterator iterator = collection.iterator();
        // while (iterator.hasNext()) {
        // Object obj = iterator.next();
        // System.out.println(obj);
        // }
        // for (Object obj : collection) {
        // System.out.println(obj);
        // }
        // List<Integer> list = new ArrayList<>();
        // list.add(934);
        // list.add(335);
        // list.add(264);
        // list.add(873);
        // list.add(232);
        // list.add(901);
        // list.add(787);
        // Collections.sort(list);
        // Collections.reverse(list);

        // Collections.sort(list, (a, b) -> Integer.compare(a % 10, b % 10));
        // for (Object obj : list) {
        // System.out.println(obj);

        // }
        List<String> val = new ArrayList<>();
        val.add("neekvfne");
        val.add("knfgkjnkewkf");
        val.add("neekfne");
        val.add("knjbfnkewkf");
        val.add("nehklnlnkmekfne");
        val.add("first");
        Comparator<String> comparator = new StringDefine();
        Collections.sort(val, comparator);
        for (Object obj : val) {
            System.out.println(obj);
        }
    }
}