import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int n;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, dfs(i,j));
			}
		}

		System.out.println(result);
	}

	public static int dfs(int y, int x) {
		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		dp[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + delta[i][0];
			int nx = x + delta[i][1];

			if (isIn(ny, nx) && arr[ny][nx] > arr[y][x]) {
				dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
			}
		}

		return dp[y][x];
	}

	public static boolean isIn(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n;
	}
}
