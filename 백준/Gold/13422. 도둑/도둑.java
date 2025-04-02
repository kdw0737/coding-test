import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());  // 테스트 케이스의 개수

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int home = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 예외 케이스: n == home일 경우
			if (n == home) {
				int total = 0;
				for (int num : arr) total += num;
				System.out.println(total < cost ? 1 : 0);
				continue;
			}

			int sum = 0;
			int cnt = 0;

			for (int i = 0; i < home; i++) {
				sum += arr[i];
			}

			if (sum < cost) {
				cnt++;
			}

			int left = 0;
			for (int right = home; right < n + home - 1; right++) {
				sum -= arr[left];
				left++;

				if (left == n) {
					left = 0;
				}

				sum += arr[right % n];

				if (sum < cost) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}
	}
}