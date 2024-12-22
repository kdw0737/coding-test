import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0));
        
        for(int i =1; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){ // 두 문자가 같으면
                stack.pop();
            }else{ // 두 문자가 다르면
                stack.push(s.charAt(i));
            }
        }
        
        if(!stack.isEmpty()) return 0;
        return 1;
    }
}