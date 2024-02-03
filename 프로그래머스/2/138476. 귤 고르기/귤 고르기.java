import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        int sum =0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : tangerine){
            map.put(n,map.getOrDefault(n, 0)+1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList,(o1,o2) -> map.get(o2) - map.get(o1));
        for(int n : keyList){
            if(sum+map.get(n) >= k){
                result++;
                break;
            }else{
                result++;
                sum += map.get(n);
            }
        }
        return result;
    }
}