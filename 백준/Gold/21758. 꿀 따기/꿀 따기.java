import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 최대로 꿀을 모으면 얼마나 모을 수 있나 ?
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		int[] prefixSum = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		prefixSum[0] = arr[0];
		for (int i = 1; i < N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		int result = 0;

		// 꿀통이 젤 오른쪽
		for (int i = 1; i < N; i++) {
			int left = prefixSum[N - 1] - prefixSum[0] - arr[i];
			int right = prefixSum[N - 1] - prefixSum[i];
			result = Math.max(result, left + right);
		}

		// 꿀통이 젤 왼쪽
		for (int i = 1; i < N - 1; i++) {
			int right = prefixSum[N - 2] - arr[i];
			int left = prefixSum[i - 1];
			result = Math.max(result, left + right);
		}

		// 꿀통이 중간
		for (int i = 1; i < N - 1; i++) {
			int left = prefixSum[i] - prefixSum[0];
			int right = prefixSum[N - 2] - prefixSum[i - 1] ;
			result = Math.max(result, left + right);
		}

		System.out.println(result);
	}
}
