import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 최대 몇라운드까지 가능한지 return
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int soldier = n;
        int item = k;
        int result = enemy.length;
        
        for(int i =0; i< enemy.length; i++){
            soldier -= enemy[i];
            pq.add(enemy[i]);
            
            if(soldier < 0){
                if(item > 0 && !pq.isEmpty()){
                    soldier += pq.poll();
                    item--;
                }else{
                    result = i;
                    break;
                }
            }
        }
        
        return result;
    }
}