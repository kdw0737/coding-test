import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> map = new HashMap<>();
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] copy_arr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy_arr);
        int index =0;
        for(int num : copy_arr){
            if(!map.containsKey(num)){
                map.put(num,index);
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: arr){
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}