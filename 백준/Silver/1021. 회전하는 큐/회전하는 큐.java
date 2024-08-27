import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;

		st = new StringTokenizer(bf.readLine());
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			deque.addLast(i + 1);
		}

		for (int i = 0; i < m; i++) {
			int targetIdx = deque.indexOf(arr[i]);
			int centerIdx = deque.size() / 2;
			if (deque.size() % 2 == 1) {
				if (targetIdx <= centerIdx) {
					while (deque.peekFirst() != arr[i]) {
						deque.addLast(deque.removeFirst());
						count++;
					}
				} else {
					while (deque.peekFirst() != arr[i]) {
						deque.addFirst(deque.removeLast());
						count++;
					}
				}
			} else {
				if (targetIdx < centerIdx) {
					while (deque.peekFirst() != arr[i]) {
						deque.addLast(deque.removeFirst());
						count++;
					}
				} else {
					while (deque.peekFirst() != arr[i]) {
						deque.addFirst(deque.removeLast());
						count++;
					}
				}
			}
			deque.removeFirst();
		}
		System.out.println(count);
	}
}
