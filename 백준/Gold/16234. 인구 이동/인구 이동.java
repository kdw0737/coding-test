import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N,L, R;
	static boolean[][] visited;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		// 인구차이 L 이상 R 이하면 인구이동
		// 인구수 계산 : (연합 인구수) / (칸의 개수) 소수점은 버림
		// 인구이동이 몇일동안 발생하는지 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		int result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[N][N];
			boolean isMoved = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						if(bfs(i, j)){
							isMoved = true;
						}
					}
				}
			}

			if(!isMoved) break;
			result++;
		}

		System.out.println(result);
	}

	public static boolean bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> nodes = new ArrayList<>();
		q.add(new int[]{y, x});
		nodes.add(new int[]{y, x});
		visited[y][x] = true;
		int sum = arr[y][x];
		int cnt = 1;

		while(!q.isEmpty()) {
			int[] node = q.poll();

			for (int i = 0; i < 4; i++) {
				int newY = node[0] + delta[i][0];
				int newX = node[1] + delta[i][1];

				if (isIn(newY, newX) && !visited[newY][newX] && Math.abs(arr[newY][newX] - arr[node[0]][node[1]]) >= L
					&& Math.abs(arr[newY][newX] - arr[node[0]][node[1]]) <= R) {
					visited[newY][newX] = true;
					q.offer(new int[] {newY, newX});
					nodes.add(new int[] {newY, newX});
					sum += arr[newY][newX];
					cnt++;
				}
			}
		}

		if(nodes.size() <= 1) return false;

		for (int[] pos : nodes) {
			arr[pos[0]][pos[1]] = sum / cnt;
		}

		return true;
	}

	public static boolean isIn(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}