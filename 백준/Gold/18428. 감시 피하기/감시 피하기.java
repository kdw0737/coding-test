import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static String[][] arr;
	static ArrayList<int[]> teachers;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new String[N][N];
		teachers = new ArrayList<>();
		ArrayList<int[]> empty = new ArrayList<>();
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = st.nextToken();
				if (arr[i][j].equals("T")) {
					teachers.add(new int[] {i, j});
				} else if (arr[i][j].equals("X")) {  // 빈 칸은 X만
					empty.add(new int[] {i, j});
				}
			}
		}

		System.out.println(checkMaps(empty, 0, 0) ? "YES" : "NO");
	}

	public static boolean checkMaps(ArrayList<int[]> empty, int idx, int depth) {
		if (depth == 3) {
			return isPossible();
		}

		for (int i = idx; i < empty.size(); i++) {
			int[] cur = empty.get(i);

			arr[cur[0]][cur[1]] = "O";

			if (checkMaps(empty, i + 1, depth + 1)) {
				return true;
			}

			arr[cur[0]][cur[1]] = "X";
		}

		return false;
	}

	public static boolean isPossible() {
		for (int[] teacher : teachers) {
			for (int i = 0; i < 4; i++) {
				int ny = teacher[0];
				int nx = teacher[1];

				while (true) {
					ny += delta[i][0];
					nx += delta[i][1];

					if (!isIn(ny, nx)) break;
					if (arr[ny][nx].equals("O")) break;
					if (arr[ny][nx].equals("S")) return false;
				}
			}
		}
		return true;
	}

	public static boolean isIn(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
