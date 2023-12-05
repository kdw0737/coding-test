import java.util.*;
import java.io.*;

public class Main {
    static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if (N == 1) {
            System.out.println(9);
            return;
        }
        long[][] dp = new long[10][N];
        long result = 0;
        for (int i = 1; i < 10; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[j][i] = dp[j + 1][i - 1] % mod;
                } else if (j == 9) {
                    dp[j][i] = dp[j - 1][i - 1] % mod;
                } else {
                    dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % mod;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            result += dp[i][N - 1];
        }
        System.out.println(result % mod);
    }
}
