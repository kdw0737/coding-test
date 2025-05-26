import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// upper bound 탐색 후 -1 해서 return
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int[] arr = new int[N];
		long left = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			left = Math.min(left, arr[i]);
		}
		long right = left + K + 1;

		while (left < right) {
			long mid = (left + right) / 2;
			long diff = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] < mid) {
					diff += mid - arr[i];
				}
			}

			if (diff <= K) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		System.out.println(left - 1);
	}
}
