import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> prior = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        for(int i =0; i<priorities.length; i++){
            prior.add(priorities[i]);
            idx.add(i);
        }
        int answer= 1;
        while(true){
            if(prior.peek()==Collections.max(prior)){
                if(idx.peek()==location){
                    return answer;
                }
                else{
                    prior.poll();
                    idx.poll();
                    answer++;
                }
                continue;
            }
            prior.offer(prior.poll());
            idx.offer(idx.poll());
            
        }
    }
}