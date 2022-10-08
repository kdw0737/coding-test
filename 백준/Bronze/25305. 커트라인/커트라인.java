import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cutLine = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i =0; i<arr.length; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length-cutLine]);
    }
}