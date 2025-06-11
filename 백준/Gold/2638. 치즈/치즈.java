import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int y, x;
	static int[][] arr;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static int time = 0;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// 2면 이상 외부공기와 닿은 치즈는 녹아버림, 내부 공기는 무시
		// 모눈종이 가장 사이드는 치즈가 없음
		// 다 녹는데 걸리는 시간 ?
		// 1 : 치즈 , 0 : 공기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		arr = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (arr[i][j] == -1) arr[i][j] = 0;
				}
			}

			visited = new boolean[y][x];

			checkOutsideAir(); // 외부 공기를 -1로 변경
			ArrayList<int[]> melting = new ArrayList<>();

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (arr[i][j] == 1 && meltingCheese(i, j)) {
						melting.add(new int[]{i, j});
					}
				}
			}

			for (int[] melt : melting) {
				arr[melt[0]][melt[1]] = 0;
			}

			time++;
			
			if (!checkArr()) {
				// 더 이상 녹일 치즈가 없으면 종료
				System.out.println(time);
				break;
			}
		}
	}

	public static boolean meltingCheese(int cy, int cx) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int ny = cy + delta[i][0];
			int nx = cx + delta[i][1];

			if (isIn(ny, nx) && arr[ny][nx] == -1) {
				cnt++;
			}
		}

		return cnt >= 2;
	}

	public static boolean checkArr() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void checkOutsideAir() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		arr[0][0] = -1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + delta[i][0];
				int nx = cur[1] + delta[i][1];

				if (isIn(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 0) {
					arr[ny][nx] = -1;
					q.add(new int[] {ny, nx});
				}
			}
		}
	}

	public static boolean isIn(int ny, int nx) {
		return 0 <= nx && nx < x && 0 <= ny && ny < y;
	}
}