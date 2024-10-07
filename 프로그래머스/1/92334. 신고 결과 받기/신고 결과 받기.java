import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,HashSet<String>> map = new HashMap<>(); // key: 신고당한 사람, value: 신고한 사람
        Map<String,Integer> idxMap = new HashMap<>(); // 사용자 인덱스 저장
        for(int i =0; i<id_list.length; i++){
            idxMap.put(id_list[i],i);
            map.put(id_list[i],new HashSet<>());
        }
        
        for(String s : report){
            String[] arr = s.split(" ");
            map.get(arr[1]).add(arr[0]);
        }
        
        for(int i =0; i<id_list.length; i++){
            HashSet<String> set = map.get(id_list[i]);
            if(set.size() >= k){ // 만약 신고횟수가 k 보다 크다면
                for(String s : set){
                    answer[idxMap.get(s)]++;
                }
            }
        }
        
        return answer;
    }
}