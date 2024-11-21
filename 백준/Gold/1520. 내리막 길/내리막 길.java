import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp; // 해당 지점부터 목적지까지 도달하는 경우의 수
	static int[][] arr;
	static int height, width;
	static int[][] delta = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		arr = new int[height][width];
		dp = new long[height][width];

		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dp[height - 1][width - 1] = 1;

		// DP를 사용하여 경로 계산
		System.out.println(dfs(0, 0));
	}

	private static long dfs(int y, int x) {
		// 이미 계산된 경로 수가 있으면 반환
		if (dp[y][x] != -1) {
			return dp[y][x];
		}

		// -1 인 경우 -> 0으로 초기화 후 자식 탐색
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y + delta[i][0];
			int nx = x + delta[i][1];

			if (isIn(ny, nx) && arr[ny][nx] < arr[y][x]) {
				dp[y][x] += dfs(ny, nx);
			}
		}

		return dp[y][x];
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && y < height && x >= 0 && x < width;
	}
}