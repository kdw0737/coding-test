import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        for(int i =0; i<queue1.length; i++){
            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }
        if((sum1 + sum2) %2 == 1){
            return -1;
        }
        long target = (sum1 + sum2)/2;
        while(true){
            if(answer>(queue1.length + queue2.length)*2)
                return -1;
            if(sum1 == target)
                break;
            else if(sum1>target){
                sum1 -= que1.peek();
                que2.add(que1.poll());
            }else{
                sum1 += que2.peek();
                que1.add(que2.poll());
            }
            answer++;
        }
        return answer;
        
    }
}