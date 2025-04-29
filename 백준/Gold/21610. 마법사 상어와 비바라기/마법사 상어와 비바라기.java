import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] delta = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

	public static void main(String[] args) throws IOException {
		// (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다
		// 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
		// 구름이 있는 칸 물의 양 1 증가
		// 구름 사라짐
		// 물 복사 후 물의 양이 2 이상인곳에 구름 만들고 물 2 감소
		// 바구니에 있는 물의 총 합 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		int M = Integer.parseInt(st.nextToken());
		int[][] move = new int[M][2];
		ArrayList<int[]> cloud = new ArrayList<>();
		int result = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}

		cloud.add(new int[] {N, 1});
		cloud.add(new int[] {N, 2});
		cloud.add(new int[] {N - 1, 1});
		cloud.add(new int[] {N - 1, 2});

		for (int i = 0; i < move.length; i++) {
			// 1. 구름을 이동
			int dir = move[i][0] - 1;
			int dis = move[i][1];
			boolean[][] visited = new boolean[N + 1][N + 1];

			for (int j = 0; j < cloud.size(); j++) {
				int y = cloud.get(j)[0];
				int x = cloud.get(j)[1];

				int newY = (y + delta[dir][0] * dis) % N;
				int newX = (x + delta[dir][1] * dis) % N;

				if (newY <= 0) newY += N;
				if (newX <= 0) newX += N;

				// 2. 구름에서 비가 내려 물의 양이 1 증가한다.
				arr[newY][newX] += 1;

				// 3. 구름이 있던 자리 저장
				visited[newY][newX] = true;
			}

			// 4. 구름 모두 삭제
			cloud.clear();

			// 5. 구름이 있던 자리에 물복사 시전
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (visited[j][k]) {
						// 구름이 있던 자리면
						for (int l = 1; l < 8; l += 2) {
							int newY = j + delta[l][0];
							int newX = k + delta[l][1];

							if (isIn(N, newY, newX) && arr[newY][newX] >= 1) {
								// 대각선 체크 했는데 범위 안에 존재하면 물 1 증가
								arr[j][k] += 1;
							}
						}
					}
				}
			}

			// 6. 새 구름 생성
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if(arr[j][k] >= 2 && !visited[j][k]) {
						cloud.add(new int[] {j, k});
						arr[j][k] -= 2;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += arr[i][j];
			}
		}

		System.out.println(result);
	}

	public static boolean isIn(int N, int y, int x) {
		return y >= 1 && y < N + 1 && x >= 1 && x < N + 1;
	}
}
