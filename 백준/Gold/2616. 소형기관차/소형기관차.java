import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int train = Integer.parseInt(bf.readLine());
		int[] people = new int[N + 1];
		int[] prefixSum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + people[i];
		}

		int[][] dp = new int[4][N + 1];

		for (int i = 1; i <= 3; i++) {
			for (int j = i * train; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - train] + prefixSum[j] - prefixSum[j - train]);
			}
		}

		System.out.println(dp[3][N]);
	}
}
