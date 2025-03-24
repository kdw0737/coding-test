import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 각 사진의 추억점수를 return
        int[] result = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i =0; i< name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int idx =0;
        for(String[] arr : photo){
            int sum =0;
            for(int i =0; i< arr.length; i++){
                if(map.containsKey(arr[i])){
                    sum += map.get(arr[i]);
                }
            }
            result[idx] = sum;
            idx++;
        }
        
        return result;
    }
}