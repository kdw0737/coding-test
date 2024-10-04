import java.io.*;
import java.util.*;

public class Main {
	static int Y, X, H;
	static int[][][] arr;
	static boolean[][][] visited;
	static int[][] delta = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
	static Queue<Node> tomatoes = new LinkedList<>();
	static int time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][Y][X];
		visited = new boolean[H][Y][X];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < Y; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < X; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						tomatoes.add(new Node(i, j, k, 0));
					}
				}
			}
		}
		bfs();
		checkArr();
	}

	public static void bfs() {
		while (!tomatoes.isEmpty()) {
			Node node = tomatoes.poll();
			visited[node.h][node.y][node.x] = true;
			time = Math.max(time, node.time);

			for (int i = 0; i < 6; i++) {
				int newH = node.h + delta[i][0];
				int newY = node.y + delta[i][1];
				int newX = node.x + delta[i][2];

				if (isIn(newH, newY, newX) && !visited[newH][newY][newX]) {
					if(arr[newH][newY][newX] == 0) {
						tomatoes.add(new Node(newH, newY, newX, node.time + 1));
						arr[newH][newY][newX] = 1;
					}
				}
			}
		}
	}

	static class Node {
		int y;
		int x;
		int h;
		int time;

		public Node(int h, int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.h = h;
			this.time = time;
		}
	}

	public static boolean isIn(int h, int y, int x) {
		return 0 <= y && 0 <= x && 0 <= h && Y > y && X > x && H > h;
	}

	public static void checkArr() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < Y; j++) {
				for (int k = 0; k < X; k++) {
					if (arr[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(time);
	}
}