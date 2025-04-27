import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int stu = Integer.parseInt(bf.readLine());

		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(bf.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				// 남학생: 받은 수의 배수 스위치 토글
				for (int j = num - 1; j < N; j += num) {
					arr[j] = (arr[j] + 1) % 2;
				}
			} else {
				// 여학생: 좌우 대칭 최대 구간 찾기
				int left = num - 1;
				int right = num - 1;

				while (left - 1 >= 0 && right + 1 < N && arr[left - 1] == arr[right + 1]) {
					left--;
					right++;
				}

				// 찾은 대칭 구간 전체 스위치 토글
				for (int j = left; j <= right; j++) {
					arr[j] = (arr[j] + 1) % 2;
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}
