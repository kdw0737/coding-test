import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum_N=1;
        int sum_M=1;
        for(int i=N; i>N-M; i--){
            sum_N *= i;
        }
        for(int i =1; i<=M; i++){
            sum_M *= i;
        }
        System.out.println(sum_N/sum_M);
    }
}