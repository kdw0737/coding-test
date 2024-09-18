import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		PriorityQueue<Integer> box = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < N; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (box.peek() < cur) {
				System.out.println(0);
				return;
			} else {
				box.add(box.poll() - cur);
			}
		}
		System.out.println(1);
	}
}
