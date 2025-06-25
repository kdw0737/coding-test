import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 최대로 받을 수 있는 컵라면 수 ?
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2]; // 0 : 데드라인 , 1 : 컵라면 수
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

		for (int i = 0; i < N; i++) {
			int deadline = arr[i][0];
			int ramen = arr[i][1];

			pq.add(ramen);
			if(pq.size() > deadline){
				pq.poll();
			}
		}

		while(!pq.isEmpty()){
			result+=pq.poll();
		}

		System.out.println(result);
	}
}
