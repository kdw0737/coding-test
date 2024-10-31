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

            // 현재 수를 maxHeap에 추가
            maxHeap.add(n);

            // maxHeap의 최대 값이 minHeap의 최소 값보다 크면, minHeap으로 이동
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            // 두 힙의 크기를 조절하여 항상 maxHeap이 더 크거나 같게 유지
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // maxHeap의 루트를 중간값으로 출력
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}