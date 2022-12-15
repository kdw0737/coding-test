import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i =0; i<N; i++){
            int num  = Integer.parseInt(bf.readLine());
            int[] dp = new int[11];
            dp[1] = 1; dp[2] = 2; dp[3] = 4;
            for(int j =4 ; j<11; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[num]);
        }
    }
}