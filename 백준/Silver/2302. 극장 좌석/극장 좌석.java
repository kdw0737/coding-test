import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int vip = Integer.parseInt(bf.readLine());
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        int sum = 1;
        int prev = 0;
        for (int i = 0; i < vip; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            sum *= dp[tmp - prev - 1];
            prev = tmp;
        }
        sum *= dp[N - prev];
        System.out.println(sum);
    }
}
