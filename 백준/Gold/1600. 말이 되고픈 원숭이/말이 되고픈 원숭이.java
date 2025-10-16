import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta_horse = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
	static int[][] delta_monkey = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int k, x, y;
	static int[][] arr;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		// 1x1 맵 예외 처리
		if (x == 1 && y == 1) {
			System.out.println(0);
			return;
		}

		arr = new int[y][x];
		visited = new boolean[y][x][k + 1];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = bfs(0, 0);
		System.out.println(result);
	}

	public static int bfs(int startY, int startX) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{startY, startX, 0, 0});
		visited[startY][startX][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int curK = cur[2];
			int curMoves = cur[3];

			for (int i = 0; i < 4; i++) {
				int ny = delta_monkey[i][0] + curY;
				int nx = delta_monkey[i][1] + curX;

				if (isIn(ny, nx) && arr[ny][nx] == 0 && !visited[ny][nx][curK]) {
					if (ny == y - 1 && nx == x - 1) {
						return curMoves + 1;
					}
					visited[ny][nx][curK] = true;
					q.add(new int[]{ny, nx, curK, curMoves + 1});
				}
			}

			if (curK < k) {
				for (int i = 0; i < 8; i++) {
					int ny = delta_horse[i][0] + curY;
					int nx = delta_horse[i][1] + curX;

					if (isIn(ny, nx) && arr[ny][nx] == 0 && !visited[ny][nx][curK + 1]) {
						if (ny == y - 1 && nx == x - 1) {
							return curMoves + 1;
						}
						visited[ny][nx][curK + 1] = true;
						q.add(new int[]{ny, nx, curK + 1, curMoves + 1});
					}
				}
			}
		}

		// 큐가 비었는데 도착점에 도달하지 못한 경우
		return -1;
	}

	public static boolean isIn(int cy, int cx) {
		return 0 <= cy && cy < y && 0 <= cx && cx < x;
	}
}
