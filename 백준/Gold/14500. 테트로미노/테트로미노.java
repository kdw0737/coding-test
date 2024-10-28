import java.io.*;
import java.util.*;

public class Main {
	static int y, x;
	static int[][] arr;
	static boolean[][] visited;
	static int sum = Integer.MIN_VALUE;
	static int[][] delta = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		visited = new boolean[y][x];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				visited[i][j] = true;
				dfs(i, j, 0, arr[i][j]);
				max = Math.max(max, sum);
				sum = 0;
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	public static void dfs(int nowY, int nowX, int depth, int tmp) {
		if (depth == 3) {
			sum = Math.max(tmp, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = nowY + delta[i][0];
			int nx = nowX + delta[i][1];

			if(isIn(ny, nx) && !visited[ny][nx]) {
				if (depth == 1) {
					visited[ny][nx] = true;
					dfs(nowY, nowX, depth + 1, tmp + arr[ny][nx]);
					visited[ny][nx] = false;
				}

				visited[ny][nx] = true;
				dfs(ny, nx, depth + 1, tmp + arr[ny][nx]);
				visited[ny][nx] = false;
			}
		}
	}

	public static boolean isIn(int j, int i) {
		if (0 <= j && j < y && 0 <= i && i < x) {
			return true;
		}
		return false;
	}
}