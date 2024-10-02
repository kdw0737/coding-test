import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(bf.readLine());
			int[] arr = new int[N];
			int[] result = new int[N];
			int idx = 0;
			int gap = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = 0; i < N; i = i + 2) {
				result[idx] = arr[i];
				idx++;
			}
			if (N % 2 == 1) {
				for (int i = N - 2; i >= 0; i = i - 2) {
					result[idx] = arr[i];
					idx++;
				}
			}
			if (N % 2 == 0) {
				for (int i = N - 1; i >= 0; i = i - 2) {
					result[idx] = arr[i];
					idx++;
				}
			}
			for (int i = 1; i < N; i++) {
				gap = Math.max(Math.abs(result[i] - result[i - 1]), gap);
			}
			gap = Math.max(Math.abs(result[N - 1] - result[0]), gap);
			System.out.println(gap);
		}
	}
}
