import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	public static void main(String[] args) throws IOException {
		// 길을 지나는 조건 : 칸의 높이가 모두 같음, 1차이 나는 길은 경사로를 놓아서 갈 수 있음
		// 지나갈 수 있는 길의 개수를 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		// 길 체크
		for (int i = 0; i < N; i++) {
			int[] row = new int[N];
			int[] col = new int[N];
			for (int j = 0; j < N; j++) {
				row[j] = arr[i][j];
				col[j] = arr[j][i];
			}
			if(checkLine(row)) result++;
			if(checkLine(col)) result++;
		}

		System.out.println(result);
	}

	public static boolean checkLine(int[] line) {
		// 평지, 오르막길, 내리막길 나눠서 체크
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			int gap = line[i + 1] - line[i];

			if (gap == 0) {
				// 평지인 경우
				continue;
			} else if (gap == 1) {
				// 오르막길인 경우
				for (int j = 0; j < L; j++) {
					int idx = i - j;
					if(idx < 0 || visited[idx] || line[i] != line[idx]) return false;
					visited[idx] = true;
				}
			} else if (gap == -1) {
				// 내리막길인 경우
				for (int j = 1; j <= L; j++) {
					int idx = i + j;
					if (idx >= N || visited[idx] || line[i + 1] != line[idx]) return false;
					visited[idx] = true;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}