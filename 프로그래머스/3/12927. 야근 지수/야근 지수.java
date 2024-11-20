import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int k : works) {
            pq.add(k);
        }

        while (n > 0) {
            int top = pq.poll();
            if (top == 0) break;  
            top--;
            n--;  
            pq.add(top);  
        }

        // 피로도 계산: 남은 작업량의 제곱의 합
        long result = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            result += (long) work * work;
        }
        return result;
    }
}
