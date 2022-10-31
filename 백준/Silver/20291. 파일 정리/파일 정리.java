import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(),".");
            String tmp = st.nextToken();
            String type = st.nextToken();
            map.put(type, map.getOrDefault(type,0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ").append(map.get(list.get(i))).append("\n");
        }
        System.out.println(sb);
    }
}
