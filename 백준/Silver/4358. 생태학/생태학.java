import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            String tree = bf.readLine();
            if (tree == null || tree.length() == 0) {
                break;
            }
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;

        }
        Object[] keyArr = map.keySet().toArray();
        Arrays.sort(keyArr);
        StringBuilder sb = new StringBuilder();
        for (Object key : keyArr) {
            sb.append(String.valueOf(key) + " ");
            sb.append(String.format("%.4f", (double) map.get(String.valueOf(key))*100 / cnt)).append('\n');
        }
        System.out.println(sb);
    }
}
