import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] arr = new int[y][x];
		boolean[][][] visited = new boolean[y][x][2];  // visited[y][x][0] = 벽 안 부순 상태, [1] = 벽 부순 상태

		for (int i = 0; i < y; i++) {
			String[] split = bf.readLine().split("");
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1, false));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.y == y - 1 && node.x == x - 1) {
				System.out.println(node.dist);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = node.y + delta[i][0];
				int nx = node.x + delta[i][1];

				if (isIn(arr, ny, nx)) {
					int wallState = node.breakWall ? 1 : 0;

					if (arr[ny][nx] == 0 && !visited[ny][nx][wallState]) {
						visited[ny][nx][wallState] = true;
						q.add(new Node(ny, nx, node.dist + 1, node.breakWall));
					} else if (arr[ny][nx] == 1 && !node.breakWall && !visited[ny][nx][1]) {
						visited[ny][nx][1] = true;
						q.add(new Node(ny, nx, node.dist + 1, true));
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static boolean isIn(int[][] arr, int y, int x) {
		return 0 <= y && y < arr.length && 0 <= x && x < arr[0].length;
	}

	public static class Node {
		int y;
		int x;
		int dist;
		boolean breakWall;

		public Node(int y, int x, int dist, boolean breakWall) {
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.breakWall = breakWall;
		}
	}
}