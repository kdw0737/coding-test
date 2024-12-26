import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int x, y;
	static int[][] arr;
	static int safeZone = 0;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		// 벽 3개를 칠 수 있음
		// 안전영역의 크기는 ?
		// 1. 벽을 먼저 친다
		// 2. 현재 상태에서 바이러스 퍼트리기
		// 3. 해당 상태에서 안전지대 검사 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		putWall(0);
		System.out.println(safeZone);
	}

	public static void putWall(int depth) {
		if (depth == 3) { // 벽 3개를 전부 설치한 경우
			bfs();
			return;
		}

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					putWall(depth + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(arr[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}

		// 깊은 복사 (deep copy)
		int[][] clone = new int[y][x]; 
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				clone[i][j] = arr[i][j]; 
			}
		}

		while(!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = node.cy + delta[i][0];
				int nx = node.cx + delta[i][1];

				if(isIn(ny,nx) && clone[ny][nx] == 0) {
					clone[ny][nx] = 2;
					q.add(new Node(ny, nx));
				}
			}
		}

		clacSafeZone(clone);
	}

	static class Node {
		int cy, cx;

		public Node(int cy, int cx) {
			this.cy = cy;
			this.cx = cx;
		}
	}

	public static boolean isIn(int cy, int cx) {
		return 0 <= cx && cx < x && 0 <= cy && cy < y;
	}

	public static void clacSafeZone(int[][] clone) {
		int cnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(clone[i][j] == 0) cnt++;
			}
		}
		safeZone = Math.max(safeZone, cnt);
	}
}
