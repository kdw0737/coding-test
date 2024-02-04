import java.util.*;

public class Solution {
    public int solution(int n) {
        int result = 0;
        while(n>0){
            if(n%2 == 0){ // n이 짝수이면
                n/=2;
            }else{
                result++;
                n-=1;
            }
        }
        return result;
    }
}