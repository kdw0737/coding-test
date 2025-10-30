import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int result = 0; // [변수명 유지] 최종 최댓값을 저장할 변수
	static int N;          // [변수명 유지] 주사위 개수
	static int[][] arr;    // [변수명 유지] 주사위 면 정보

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bf.readLine());
		arr = new int[N][6];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
			arr[i][4] = Integer.parseInt(st.nextToken());
			arr[i][5] = Integer.parseInt(st.nextToken());
		}

		// 1번 주사위의 "아랫면"이 될 수 있는 6가지 경우(i=0~5)를 모두 시도합니다.
		for (int i = 0; i < 6; i++) {

			int currentSum = 0;

			int bottom = i;
			int top = setTop(bottom);

			int bottomValue = arr[0][bottom];
			int topValue = arr[0][top];

			currentSum += calcSide(bottomValue, topValue);

			for (int j = 1; j < N; j++) {

				int newBottomValue = topValue;
				int newBottomIndex = -1;

				for (int k = 0; k < 6; k++) {
					if (arr[j][k] == newBottomValue) {
						newBottomIndex = k;
						break;
					}
				}

				int newTopIndex = setTop(newBottomIndex);
				int newTopValue = arr[j][newTopIndex];

				currentSum += calcSide(newBottomValue, newTopValue);

				topValue = newTopValue;
			}

			result = Math.max(result, currentSum);
		}

		System.out.println(result);
	}

	public static int setTop(int bottom) {
		switch (bottom) {
			case 0: return 5;
			case 1: return 3;
			case 2: return 4;
			case 3: return 1;
			case 4: return 2;
			case 5: return 0;
			default: return -1;
		}
	}

	public static int calcSide(int bottomVal, int topVal) {
		if (bottomVal == 6 || topVal == 6) {
			if (bottomVal == 5 || topVal == 5) {
				return 4;
			} else {
				return 5;
			}
		} else {
			return 6;
		}
	}
}