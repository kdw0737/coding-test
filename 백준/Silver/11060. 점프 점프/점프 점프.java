import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j < i + arr[i] + 1; j++) {
                if (j > N) {
                    break;
                }
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        System.out.println(dp[N]==Integer.MAX_VALUE-1?-1:dp[N]);
    }
}