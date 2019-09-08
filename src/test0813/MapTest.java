package test0813;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("aa", 22);
        map.put("bb", 33);
        map.put("cc", 33);

        for (String o :map.keySet() ) {
            System.out.println(o+":>>"+map.get(o));
        }

    }
}
