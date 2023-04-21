import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int count = 0;
        int curbox = 1;
        while(true){
            if(curbox<=order[idx]){
                for(int i =curbox; i<order[idx]; i++){
                    stack.push(i);
                }
            }else{
                if(!stack.isEmpty()){
                if(stack.peek() != order[idx] && order[idx]!=curbox){
                    break;
                }else{
                    stack.pop();
                }
            }
            }
            curbox = Math.max(order[idx]+1,curbox);
            count++;
            idx++;
            if(idx==order.length)
                break;
        }
        return count;
    }
}