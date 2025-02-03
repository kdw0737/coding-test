import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			que.add(i);
		}

		for (int i = 1; i < n; i++) {
			long cnt = (long) i * i * i;
			long removeIdx = (cnt - 1) % que.size();

			for (int j = 0; j < removeIdx; j++) {
				que.add(que.poll());
			}
			que.poll();
		}
		System.out.println(que.poll());
	}
}
