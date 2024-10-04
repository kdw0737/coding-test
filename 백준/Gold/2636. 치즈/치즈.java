import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int Y, X;
	static int[][] arr;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < X; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}

	public static void bfs() {
		// 기본환경 설정
		boolean[][] visited = new boolean[Y][X];
		Queue<Node> airs = new LinkedList<>();

		//초기 설정 ( 시작은 0,0 )
		airs.add(new Node(0, 0));
		visited[0][0] = true;

		//다음번에 녹을 치즈 저장 큐
		Queue<Node> nextAirs = new LinkedList<>();

		int hour = 0, prev = 0;

		while (true) {
			//bfs로 완전탐색
			while (!airs.isEmpty()) {
				Node node = airs.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y + delta[i][0];
					int nx = node.x + delta[i][1];

					if(isIn(ny,nx) && !visited[ny][nx]) {
						//방문 체크
						visited[ny][nx] = true;

						// 해당 지점이 공기면 airs에 넣고 다음에 탐색
						if (arr[ny][nx] == 0) {
							airs.add(new Node(ny, nx));
						} else {
							// 해당 지점이 치즈면 nextAirs에 넣고 다음에 탐색
							nextAirs.add(new Node(ny, nx));
						}
					}
				}
			} // 1시간 경과

			//새로운 공기가 없으면 종료
			if (nextAirs.isEmpty()) {
				break;
			}

			//새로운 공기가 있으면 1시간 더 탐색
			else {
				hour++;
				prev = nextAirs.size();

				//두 개의 큐를 스왑
				Queue<Node> temp = airs;
				airs = nextAirs;
				nextAirs = temp;
			}
		}

		System.out.println(hour);
		System.out.println(prev);
	}

	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
}