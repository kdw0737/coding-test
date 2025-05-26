import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		cnt = 0;
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				find(num);

				if (countBingo() >= 3) {
					System.out.println(cnt);
					return;
				}
			}
		}


	}

	public static void find(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(arr[i][j] == num) {
					arr[i][j] = -1;
					cnt++;
					return;
				}
			}
		}
	}

	public static int countBingo() {
		int bingo = 0;

		for (int i = 0; i < 5; i++) {
			if (arr[i][0] == -1 && arr[i][1] == -1 && arr[i][2] == -1 && arr[i][3] == -1 && arr[i][4] == -1) {
				bingo++;
			}
			if(arr[0][i] == -1 && arr[1][i] == -1 && arr[2][i] == -1 && arr[3][i] == -1 && arr[4][i] == -1) {
				bingo++;
			}
		}

		if(arr[0][0] == -1 && arr[1][1] == -1 && arr[2][2] == -1 && arr[3][3] == -1 && arr[4][4] == -1) {
			bingo++;
		}
		if (arr[0][4] == -1 && arr[1][3] == -1 && arr[2][2] == -1 && arr[3][1] == -1 && arr[4][0] == -1) {
			bingo++;
		}

		return bingo;
	}
}
