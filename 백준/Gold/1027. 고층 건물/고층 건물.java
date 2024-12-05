import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int[] buildings = new int[N];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		int maxCnt = 0;

		for (int i = 0; i < N; i++) {
			double degree = 1000000000;
			int cnt = 0;

			for (int j = i - 1; j >= 0; j--) {
				if (degree > (double) (buildings[j] - buildings[i]) / (j - i)) {
					degree = (double) (buildings[j] - buildings[i]) / (j - i);
					cnt++;
				}
			}
			degree = -1000000000;
			for (int j = i + 1; j < N; j++) {
				if (degree < (double) (buildings[j] - buildings[i]) / (j - i)) {
					degree = (double) (buildings[j] - buildings[i]) / (j - i);
					cnt++;
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		System.out.println(maxCnt);
	}
}