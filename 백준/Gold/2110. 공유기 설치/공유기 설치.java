import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int home = Integer.parseInt(st.nextToken());
		int machine = Integer.parseInt(st.nextToken());
		int[] arr = new int[home];

		for (int i = 0; i < home; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);

		int left = 1;
		int right = arr[arr.length - 1] - arr[0];
		int result = 0;

		while(left <= right) {
			int mid = (left + right) / 2;

			if (canInstall(home, machine, arr, mid)) {
				// 만약 설치 개수가 많다면
				result = mid;
				left = mid + 1;
			} else {
				// 만약 설치 개수가 적다면
				right = mid - 1;
			}
		}

		System.out.println(result);
	}

	public static boolean canInstall(int home, int machine, int[] arr, int mid) {
		// 공유기 사이의 거리가 mid 이상 일 때, 최대로 설치할 수 있는 공유기 개수
		int cur = arr[0];
		int cnt = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - cur >= mid) {
				cur = arr[i];
				cnt++;
			}
		}

		if (cnt >= machine) {
			return true;
		} else {
			return false;
		}
	}
}
