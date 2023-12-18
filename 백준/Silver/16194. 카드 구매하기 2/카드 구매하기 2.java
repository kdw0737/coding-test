import java.util.*;
import java.io.*;

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
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = arr[1];
        dp[2] = Math.min(arr[1] * 2, arr[2]);
        for (int i = 3; i < N + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(Math.min(arr[i], dp[j] + dp[i - j]), dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}