import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(bf.readLine(), i);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2) -> o1.getValue() - o2.getValue());
        for (int i = 0; i < K; i++) {
            if (list.size() == i) {
                break;
            }
            String str = String.valueOf(list.get(i));
            String[] arr = str.split("=");
            System.out.println(arr[0]);
        }
    }
}
