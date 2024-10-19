import java.io.*;
import java.util.*;

/***
 * 초기 상어 크기 : 2
 * 본인보다 큰 물고기 통과 불가능
 * 본인보다 작은 물고기만 식사 가능 ( 크기가 같으면 통과만 가능 식사 x )
 * 1. 가까운 물고기 먼저
 * 2. 거리가 같으면 y 값이 작은 물고기 우선
 * 3. 거리도 같고 y도 같으면 x가 작은 물고기 우선
 * 크기가 2인 경우 2마리 먹으면 3으로 진화 가능
 */
public class Main {
	static int N;
	static int[][] arr;
	static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		int startX = 0; int startY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					startX = j;
					startY = i;
					arr[i][j] = 0;
				}
			}
		}
		System.out.println(bfs(startY, startX));
	}

	private static int bfs(int startY, int startX) {
		int time = 0;
		int fish = 2;
		int size = 2;

		while (true) {
			Node minNode = new Node(-1, -1, Integer.MAX_VALUE);
			boolean[][] visited = new boolean[N][N];
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(startY, startX, 0));
			visited[startY][startX] = true;

			while (!q.isEmpty()) {
				Node node = q.poll();

				if (node.dist > minNode.dist) break; // 더 먼 거리 탐색으로 넘어갔다면 탐색 중단
				if (arr[node.y][node.x] > size) continue; // 상어보다 큰 물고기가 있는 칸인 경우

				if (arr[node.y][node.x] != 0 && arr[node.y][node.x] < size) { // 물고기가 있는 칸이면서 상어보다 작은 물고기인 경우
					if (node.dist < minNode.dist || (node.dist == minNode.dist && (node.y < minNode.y || (node.y == minNode.y && node.x < minNode.x)))) {
						minNode = node; // 우선순위 업데이트
					}
				}

				for (int i = 0; i < 4; i++) {
					int ny = node.y + delta[i][0];
					int nx = node.x + delta[i][1];

					if (isIn(ny, nx) && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new Node(ny, nx, node.dist + 1));
					}
				}
			}

			if (minNode.dist == Integer.MAX_VALUE) {
				break; // 먹을 수 있는 물고기가 없을 경우 종료
			}

			// 상어가 물고기를 먹음
			time += minNode.dist;
			fish--;
			startY = minNode.y; // 상어의 위치 업데이트
			startX = minNode.x; // 상어의 위치 업데이트
			arr[minNode.y][minNode.x] = 0; // 먹은 물고기 제거

			if (fish == 0) {
				size++;
				fish = size;
			}
		}

		return time;
	}


	static class Node {
		int y,x, dist;

		Node(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

	private static boolean isIn(int y, int x) {
		if (0 <= y && y < N && 0 <= x && x < N) {
			return true;
		}
		return false;
	}
}