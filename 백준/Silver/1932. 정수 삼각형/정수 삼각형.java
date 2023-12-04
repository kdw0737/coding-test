import java.security.Key;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if (N == 1) {
            System.out.println(bf.readLine());
            return;
        }
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            String[] str = bf.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        dp[0][0] = arr[0][0];
        dp[1][0] = dp[0][0] + arr[1][0];
        dp[1][1] = dp[0][0] + arr[1][1];
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j - 1], arr[i][j] + dp[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sum = Math.max(sum, dp[N - 1][i]);
        }
        System.out.println(sum);
    }
}
