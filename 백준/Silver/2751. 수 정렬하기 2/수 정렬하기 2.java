import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<N; i++){
            list.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int a : list){
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
