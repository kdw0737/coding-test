import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int y,x, t;
	static int[][] arr;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	static ArrayList<int[]> purifier;
	public static void main(String[] args) throws IOException {
		// 해당 칸 / 5 만큼 상하좌우로 확산
		// 해당 칸에 남은 먼지 : 기존 양 - 기존 양 / 5 * 확산된 칸의 개수
		// 청정기 기준 위쪽은 반시계 방향 , 아래쪽은 시계방향 순환
		// T초후 남아있는 미세먼지 합 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[y][x];
		purifier = new ArrayList<>();

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < x; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					purifier.add(new int[] {i, j});
				}
			}
		}

		for (int i = 0; i < t; i++) {
			dfs();
		}

		int result = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (arr[i][j] != -1) {
					result += arr[i][j];
				}
			}
		}

		System.out.println(result);
	}

	public static void dfs() {
		int[][] spread = new int[y][x];
		// 1. 새로운 배열에 완전탐색으로 먼지 확산
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				int cnt = 0;
				if (arr[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int ny = i + delta[k][0];
						int nx = j + delta[k][1];

						if (isIn(ny, nx) && arr[ny][nx] != -1) {
							spread[ny][nx] += arr[i][j] / 5;
							cnt++;
						}
					}
					spread[i][j] += arr[i][j] - (arr[i][j] / 5) * cnt;
				}
			}
		}

		// 2. 먼지 순환
		int upper = purifier.get(0)[0]; // 위쪽 청정기 행 위치
		// 위쪽 ←
		for (int i = upper - 1; i > 0; i--) spread[i][0] = spread[i - 1][0];
		// 위쪽 ↑
		for (int i = 0; i < x - 1; i++) spread[0][i] = spread[0][i + 1];
		// 위쪽 →
		for (int i = 0; i < upper; i++) spread[i][x - 1] = spread[i + 1][x - 1];
		// 위쪽 ↓
		for (int i = x - 1; i > 1; i--) spread[upper][i] = spread[upper][i - 1];
		spread[upper][1] = 0; // 청정기로 들어간 먼지 제거

		int lower = purifier.get(1)[0]; // 아래쪽 청정기 행 위치
		// 아래쪽 ←
		for (int i = lower + 1; i < y - 1; i++) spread[i][0] = spread[i + 1][0];
		// 아래쪽 ↓
		for (int i = 0; i < x - 1; i++) spread[y - 1][i] = spread[y - 1][i + 1];
		// 아래쪽 →
		for (int i = y - 1; i > lower; i--) spread[i][x - 1] = spread[i - 1][x - 1];
		// 아래쪽 ↑
		for (int i = x - 1; i > 1; i--) spread[lower][i] = spread[lower][i - 1];
		spread[lower][1] = 0; // 청정기로 들어간 먼지 제거

		spread[upper][0] = -1;
		spread[lower][0] = -1;

		// 3. 확산 배열을 원본 배열에 복자
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				arr[i][j] = spread[i][j];
			}
		}
	}

	public static boolean isIn(int ny, int nx) {
		return 0 <= ny && ny < y && 0 <= nx && nx < x;
	}
}
