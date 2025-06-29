import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 굴다리 길이
		int M = Integer.parseInt(bf.readLine()); // 가로등 개수
		int[] arr = new int[M];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N;
		int answer = N;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (canCover(arr, N, mid)) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(answer);
	}

	static boolean canCover(int[] arr, int N, int H) {
		int lastCovered = 0;

		for (int pos : arr) {
			int start = pos - H;
			int end = pos + H;

			if (start > lastCovered) {
				return false;
			}
			lastCovered = Math.max(lastCovered, end);
		}

		return lastCovered >= N;
	}
}
