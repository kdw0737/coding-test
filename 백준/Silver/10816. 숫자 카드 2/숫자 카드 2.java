import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i =0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(key,0)).append(" ");
        }
        System.out.println(sb);
    }
}