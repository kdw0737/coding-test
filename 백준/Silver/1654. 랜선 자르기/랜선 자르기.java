import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		long left = 1;
		long right = 1;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			right = Math.max(right, arr[i]);
		}
		right++;

		while(left < right) {
			long mid = (left + right) / 2;

			if (checkCount(mid) >= N) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println(left - 1);
	}

	public static long checkCount(long mid) {
		long cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i] / mid;
		}
		return cnt;
	}
}
