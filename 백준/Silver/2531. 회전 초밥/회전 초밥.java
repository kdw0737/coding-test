import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 접시의 수 : n , 초밥 종류 수 : d , 연속해서 먹는 접시의 수 : k , 쿠폰 번호 : c
		// 먹을 수 있는 초밥 종류의 최대값?
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] cnt = new int[3001];
		int num = 0; // 초밥 종류 개수 count
		int max = 0; // 결과값

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		for (int i = 0; i < k; i++) {
			if(cnt[arr[i]] == 0) num++;
			cnt[arr[i]]++;
		}

		max = (cnt[c] == 0) ? num + 1 : num;

		for (int i = 1; i < n; i++) {
			// 앞 제거
			int prev = arr[i - 1];
			cnt[prev]--;
			if(cnt[prev] == 0) num--;

			//뒤 초밥 추가
			int next = arr[(i + k - 1) % n];
			if(cnt[next] == 0) num++;
			cnt[next]++;

			max = Math.max(max, (cnt[c] == 0) ? num + 1 : num);
		}

		System.out.println(max);
	}
}
