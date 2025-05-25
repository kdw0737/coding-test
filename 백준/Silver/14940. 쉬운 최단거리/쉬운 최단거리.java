import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int y, x;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		// 0 : 불가능 , 1 : 가능 , 2 : 목표점
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		result = new int[y][x];
		visited = new boolean[y][x];
		Node start = new Node();

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					start.cy = i;
					start.cx = j;
					start.dist = 0;
				}

				if (arr[i][j] == 1) {
					result[i][j] = -1;
				}
			}
		}

		visited[start.cy][start.cx] = true;
		bfs(start);

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = node.cy + delta[i][0];
				int nx = node.cx + delta[i][1];

				if (isIn(ny, nx) && !visited[ny][nx] && arr[ny][nx] != 0) {
					visited[ny][nx] = true;
					result[ny][nx] = node.dist + 1;
					q.add(new Node(ny, nx, node.dist + 1));
				}
			}
		}
	}

	public static boolean isIn(int cy, int cx) {
		return 0 <= cy && cy < y && 0 <= cx && cx < x;
	}

	static class Node {
		int cy;
		int cx;
		int dist;

		public Node(int cy, int cx, int dist) {
			this.cy = cy;
			this.cx = cx;
			this.dist = dist;
		}

		public Node() {
		}
	}
}