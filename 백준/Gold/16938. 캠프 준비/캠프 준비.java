import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// L <= 문제난이도 합 <= R
		// 가장 어려운 문제 - 가장 쉬운 문제 >= X
		// 문제 고르는 방법 수 ?
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int result = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < (1 << N); i++) {
			int bits = Integer.bitCount(i);
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			if(bits < 2) continue;

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
					min = Math.min(min, arr[j]);
					max = Math.max(max, arr[j]);
				}
			}

			if (L <= sum && sum <= R && (max - min) >= X) {
				result++;
			}
		}

		System.out.println(result);
	}
}