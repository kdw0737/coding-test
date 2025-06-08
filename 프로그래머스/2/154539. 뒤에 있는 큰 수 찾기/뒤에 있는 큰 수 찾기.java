import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        // 자신보다 크면서 가장 가까운 수 
        // 없으면 -1
        int n = numbers.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        for(int i = n -1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }
            
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }
        
        return result;
    }
}