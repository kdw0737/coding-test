import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][M + 1];
        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        for (int i = 1; i < N + 1; i++) {
            int drop = arr[i];
            for (int j = 0; j < M + 1; j++) {
                if (j == 0) { //1번에서 이동하지 않은경우
                    if (drop == 1) {
                        dp[i][0] = dp[i - 1][0] + 1;
                    } else {
                        dp[i][0] = dp[i - 1][0];
                    }
                    continue;
                } else {
                    if (j % 2 != 0) { // 현재 2번에 위치
                        if (drop == 1) { // 1번에 자두가 떨어지는 경우
                            dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]); // 움직여서 받는 경우, 가만히 있는 경우
                        } else { //2번에 자두가 떨어지는 경우
                            dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]); // 가만히 서서 받는 경우, 움직이지 않는 경우
                        }
                    } else { //현재 1번에 위치
                        if (drop == 1) { // 1번에 자두가 떨어지는 경우
                            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1); // 움직이지 않는 경우 , 가만히 서서 받는 경우
                        } else { //2번에 자두가 떨어지는 경우
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1); // 가만히 있는 경우, 움직여서 받는 경우
                        }
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}
