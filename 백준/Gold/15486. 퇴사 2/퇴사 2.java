import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[2][N + 2];
		int[] dp = new int[N + 2];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N + 2; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
			if (i + arr[0][i] <= N + 1) {
				dp[i + arr[0][i]] = Math.max(dp[i + arr[0][i]], arr[1][i] + max);
			}
		}
		System.out.println(dp[N + 1]);
	}
}