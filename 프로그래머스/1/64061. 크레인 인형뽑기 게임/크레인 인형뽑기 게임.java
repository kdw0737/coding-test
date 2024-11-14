import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>(); // 바구니
        int result = 0;
        for(int i : moves){
            for(int j = 0; j < board.length; j++){
                if(board[j][i-1] != 0){
                    stack.push(board[j][i-1]);
                    board[j][i-1] = 0;
                    break;
                }
            }
            if(!stack.isEmpty()){
                int n = stack.pop();
                if(!stack.isEmpty() && stack.peek() == n){
                    stack.pop();
                    result += 2;
                }else{
                    stack.push(n);
                }
            }
        }
        return result;
    }
}