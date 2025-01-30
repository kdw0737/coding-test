import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x, y;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		// 0은 전류가 통함, 1은 전류가 안통함
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		visited = new boolean[y][x];
		for (int i = 0; i < y; i++) {
			String[] tmp = bf.readLine().split("");
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		for (int i = 0; i < x; i++) {
			if (arr[0][i] == 0 && !visited[0][i]) {
				visited[0][i] = true;
				dfs(0, i);
			}
		}

		System.out.println("NO");
	}

	public static void dfs(int cy, int cx) {
		if (cy == y - 1) {
			System.out.println("YES");
			System.exit(0);
		}

		for (int i = 0; i < 4; i++) {
			int ny = cy + delta[i][0];
			int nx = cx + delta[i][1];
			if (isIn(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 0) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}

	public static boolean isIn(int ny, int nx) {
		return 0 <= ny && ny < y && 0 <= nx && nx < x;
	}
}