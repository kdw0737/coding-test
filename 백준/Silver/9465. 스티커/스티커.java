import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] arr = new int[2][N];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][N];
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(N>1) {
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];
            }
            if(N>2) {
                for (int j = 2; j < N; j++) {
                    dp[0][j] = Math.max(dp[0][j - 2], Math.max(dp[1][j - 2], dp[1][j - 1])) + arr[0][j];
                    dp[1][j] = Math.max(dp[1][j - 2], Math.max(dp[0][j - 2], dp[0][j - 1])) + arr[1][j];
                }
            }
            if(N!=1) {
                System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
            }else{
                System.out.println(Math.max(dp[0][0], dp[1][0]));
            }
        }
    }
}