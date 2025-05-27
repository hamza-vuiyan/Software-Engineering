import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        System.out.println("Enter the Text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        StringTokenizer st = new StringTokenizer(text);
        
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
        
    }
}
