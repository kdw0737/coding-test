import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int tmp_gcd = arr[1]-arr[0];
        for(int i =2; i<N; i++){
            tmp_gcd = gcd(tmp_gcd,arr[i]-arr[i-1]);
        }
        for(int i =2; i<=tmp_gcd/2; i++){
            if(tmp_gcd%i==0)
                sb.append(i).append(" ");
        }
        sb.append(tmp_gcd);
        System.out.print(sb);
    }

    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a =b;
            b =r;
        }
        return a;
    }
}