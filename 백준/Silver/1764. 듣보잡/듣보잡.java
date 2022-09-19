import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i<N; i++){
            map.put(bf.readLine(),1);
        }
        for(int i =0; i<M; i++){
            String key = bf.readLine();
            if(map.containsKey(key))
                list.add(key);
        }
        Collections.sort(list);
        for(String key : list)
            sb.append(key).append("\n");
        System.out.println(list.size());
        System.out.println(sb);
    }
}