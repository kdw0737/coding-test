import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == 1) {
			System.out.println(K);
			return;
		} else if (K == 1) {
			System.out.println(1);
			return;
		}

		int[][] dp = new int[K + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			dp[1][i] = 1;
		}
		for (int i = 1; i <= K; i++) {
			dp[i][1] = i;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 2; j <= N; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
			}
		}
		System.out.println(dp[K][N]);
	}
}