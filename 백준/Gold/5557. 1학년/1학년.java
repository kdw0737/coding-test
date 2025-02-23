import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long[][] dp = new long[21][N - 1];
		dp[arr[0]][0] = 1;

		for (int i = 1; i < N - 1; i++) {
			int num = arr[i];
			for (int j = 0; j <= 20; j++) {
				if (dp[j][i - 1] > 0) {
					if (j + num <= 20) {
						dp[j + num][i] += dp[j][i - 1];
					}
					if (j - num >= 0) {
						dp[j - num][i] += dp[j][i - 1];
					}
				}
			}
		}

		System.out.println(dp[arr[N - 1]][N - 2]);
	}
}