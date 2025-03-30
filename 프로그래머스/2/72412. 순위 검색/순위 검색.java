import java.util.*;
class Solution {
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        // 조건에 맞는 사람수를 배열에 담아서 return 
        
        int[] result = new int[query.length];
        int idx = 0;
        
        for(String str : info){
            String[] arr = str.split(" ");
            makeCases(arr, "", 0, Integer.parseInt(arr[4]));
        }
        
        for (ArrayList<Integer> list : map.values()) {
            Collections.sort(list);
        }
        
        for(String str : query){
            String[] arr = str.replaceAll(" and ", " ").split(" ");
            String k = arr[0]+arr[1]+arr[2]+arr[3];
            String score = arr[4];
            
            if(map.containsKey(k)){
                ArrayList<Integer> list = map.get(k);
                int left = 0; 
                int right = list.size();
                
                while(left < right){
                    int mid = (left + right) / 2;
                    
                    if(list.get(mid) < Integer.parseInt(score)){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                result[idx] = list.size() - left;
            }
            idx++;
        }
        return result;
    }
    
    public void makeCases(String[] arr, String str, int depth, int score){
        if(depth == 4){
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(score);
            return;
        }
        
        makeCases(arr, str + arr[depth], depth + 1, score);
        makeCases(arr, str + "-", depth + 1, score);
    }
}