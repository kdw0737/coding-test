import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        // RT / CF / JM / AN - 점수가 같은 경우 사전순
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i =0; i<choices.length; i++){
            String[] arr = survey[i].split("");
            map.put(arr[0], map.getOrDefault(arr[0], 0));
            map.put(arr[1], map.getOrDefault(arr[1], 0));
            
            if(choices[i] == 1){ // 매우 비동의
                map.put(arr[0] , map.getOrDefault(arr[0], 0) + 3);
            }else if(choices[i] == 2){ // 비동의
                map.put(arr[0] , map.getOrDefault(arr[0], 0) + 2);
            }else if(choices[i] == 3){ // 약간 비동의
                map.put(arr[0] , map.getOrDefault(arr[0], 0) + 1);
            }else if(choices[i] == 5){ // 약간 동의
                map.put(arr[1] , map.getOrDefault(arr[1], 0) + 1);
            }else if(choices[i] == 6){ // 동의
                map.put(arr[1] , map.getOrDefault(arr[1], 0) + 2);
            }else if(choices[i] == 7){ // 매우 동의
                map.put(arr[1] , map.getOrDefault(arr[1], 0) + 3);
            }
        }
        
        String result = "";
        if(map.containsKey("R") && map.containsKey("T")){
        if(map.get("R") < map.get("T")){
            result += "T";
        }else{
            result += "R";
        }
        }else{
            result += "R";
        }
        
        if(map.containsKey("C") && map.containsKey("F")){
        if(map.get("C") < map.get("F")){
            result += "F";
        }else{
            result += "C";
        }
        }else{
            result += "C";
        }
        
        if(map.containsKey("J") && map.containsKey("M")){
        if(map.get("J") < map.get("M")){
            result += "M";
        }else{
            result += "J";
        }
        }else{
            result += "J";
        }
        
        if(map.containsKey("A") && map.containsKey("N")){
        if(map.get("A") < map.get("N")){
            result += "N";
        }else{
            result += "A";
        }
        }else{
            result += "A";
        }
        
        return result;
    }
}