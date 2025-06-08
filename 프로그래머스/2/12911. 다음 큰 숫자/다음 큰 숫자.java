class Solution {
    public int solution(int n) {
        int result = n + 1;
        
        while(true){
            if(bitCnt(n) == bitCnt(result)){
                break;
            }
            
            result++;
        }
        
        return result;
    }
    
    public int bitCnt(int n){
        int cnt = 0;
        
        while(n > 0){
            cnt += (n & 1);
            n >>= 1;
        }
        
        return cnt;
    }
}