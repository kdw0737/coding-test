import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] prefixSum = new int[n + 1]; // prefixSum[0] = 0으로 시작

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefixSum[i + 1] = prefixSum[i] + arr[i];
		}

		int left = 0;
		int right = 1;
		int result = Integer.MAX_VALUE;

		while (right <= n) {
			int sum = prefixSum[right] - prefixSum[left];

			if (sum >= s) {
				result = Math.min(result, right - left);
				left++;
			} else {
				right++;
			}
		}

		System.out.println(result == Integer.MAX_VALUE ? 0 : result);
	}
}
