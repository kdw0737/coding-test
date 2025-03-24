import java.util.*;
class Solution {
    String[] arr = {"A", "E", "I", "O", "U"};
    ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        dfs("");
            
        for(int i =0; i< list.size(); i++){
            if(word.equals(list.get(i))){
                return i;
            }
        }
        return 0;
    }
    
    public void dfs(String result){
        list.add(result);
        
        if(result.length() == 5){
            return;
        }
        
        for(int i =0; i<5; i++){
            dfs(result + arr[i]);
        }
    }
}