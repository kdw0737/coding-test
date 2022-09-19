import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> x_map = new HashMap<>();
        HashMap<Integer, Integer> y_map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<3; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x_map.put(x, x_map.getOrDefault(x,0)+1);
            y_map.put(y,y_map.getOrDefault(y,0)+1);
        }
        int x=0,y=0;
        for(int key: x_map.keySet()){
            int value = x_map.get(key);
            if(value == 1)
                x=key;
        }
        for(int key: y_map.keySet()){
            int value = y_map.get(key);
            if(value == 1)
                y=key;
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}