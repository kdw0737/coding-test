import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            int tmp;
            if((100-progresses[i])%speeds[i] == 0)
                tmp = (100-progresses[i])/speeds[i];
            else
                tmp = ((100-progresses[i])/speeds[i])+1;
            que.add(tmp);
        }
        while(!que.isEmpty()){
            int tmp = que.poll();
            int count =1;
            while(!que.isEmpty() && tmp >= que.peek()){
                count++;
                que.poll();
            }
            result.add(count);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}