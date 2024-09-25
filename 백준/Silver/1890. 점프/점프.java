import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = arr[i][j];
				if(num==0)
					break;
				if (i + num < N) {
					dp[i + num][j] += dp[i][j];
				}
				if (j + num < N) {
					dp[i][j + num] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}
}