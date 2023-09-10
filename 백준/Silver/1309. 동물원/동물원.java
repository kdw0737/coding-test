import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = (dp[i - 2] + (dp[i - 1] * 2)) % 9901;
        }
        System.out.println(dp[N]);
    }
}