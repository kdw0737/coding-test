import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int sum = 0;
		int cnt = 1;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < x; i++) {
			sum += arr[i];
		}

		int max = sum;

		for (int i = x; i < n; i++) {
			sum = sum - arr[i - x] + arr[i];
			if (sum > max) {
				max = sum;
				cnt = 1;
			} else if (sum == max) {
				cnt++;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
