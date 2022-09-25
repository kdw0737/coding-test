import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i =0; i<N; i++) {
            int a = Integer.parseInt(bf.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < a; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String tmp = st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int result =1;
            for(String key : map.keySet()){
                int value = map.get(key);
                result *= (value+1);
            }
            System.out.println(result-1);
        }
    }
}