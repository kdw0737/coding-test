import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		// 최소 힙과 최대 힙을 사용하여 중간값을 찾는다.
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 값들
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값들

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(bf.readLine());
			if (maxHeap.size() <= minHeap.size()) {
				maxHeap.add(n);
				if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
					maxHeap.add(minHeap.poll());
					minHeap.add(maxHeap.poll());
				}
			} else {
				minHeap.add(n);
				if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
					maxHeap.add(minHeap.poll());
					minHeap.add(maxHeap.poll());
				}
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);
	}
}