import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int weightLimit = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N+1][weightLimit+1];
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < weightLimit + 1; j++) {
                if (arr[i][0] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][weightLimit]);
    }
}