import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		int[] dp = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			if(arr[i][1] == 0) continue;
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j][1] < arr[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}
		System.out.println(N - max);
	}
}