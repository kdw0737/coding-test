import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] copy = Arrays.copyOf(arr,N);
        Arrays.sort(copy);
        HashMap<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for(int i =0; i<N; i++){
            if(!map.containsKey(copy[i])) {
                map.put(copy[i], index);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n: arr){
            sb.append(map.get(n)).append(" ");
        }
        System.out.println(sb);
    }
}