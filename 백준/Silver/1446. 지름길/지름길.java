import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] dp = new int[10001];
		for (int i = 0; i <= D; i++) {
			dp[i] = i;
		}

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			if (end > D) continue;
			list.add(new int[]{start, end, dist});
		}

		for (int i = 0; i <= D; i++) {
			if (i != 0) dp[i] = Math.min(dp[i], dp[i-1] + 1);  // 기본적으로 1km 이동

			for (int[] shortcut : list) {
				int start = shortcut[0];
				int end = shortcut[1];
				int dist = shortcut[2];

				if (start == i) {
					dp[end] = Math.min(dp[end], dp[start] + dist);
				}
			}
		}

		System.out.println(dp[D]);
	}
}
