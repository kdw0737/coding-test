import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 배치가 가능한 문장이면 Yes 아니면 No return
        Queue<String> fq = new LinkedList<>();
        Queue<String> sq = new LinkedList<>();
        
        for(String str : cards1){
            fq.add(str);
        }
        for(String str : cards2){
            sq.add(str);
        }
        
        for(String str : goal){
            if(!fq.isEmpty() && fq.peek().equals(str)){
                fq.poll();
            }else if(!sq.isEmpty() && sq.peek().equals(str)){
                sq.poll();
            }else{
                return "No";
            }
        }
        
        return "Yes";
    }
}