import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int D = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int first = 1;
        int second = 1;
        int[] dp = new int[D + 1];
        while (true) {
            dp[1] = first;
            dp[2] = second;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            if (dp[D] == k) {
                break;
            } else {
                if (k - first < second) {
                    first++;
                    second = first;
                    continue;
                }
                second++;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }
}
