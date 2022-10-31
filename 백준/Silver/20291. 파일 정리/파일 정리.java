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
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        for(String key : keyList){
            sb.append(key+" "+map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}