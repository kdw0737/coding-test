import java.util.*;

class Solution {
    String[] userIds;
    String[] banIds;
    HashSet<HashSet<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        // 가능한 아이디 목록의 수 return 
        
        userIds = user_id;
        banIds = banned_id;
        
        dfs(new HashSet<>(), 0);
        
        return result.size();
    }
    
    public void dfs(HashSet<String> set, int depth){
        if(depth == banIds.length){
            result.add(set);
            return;
        }
        
        for(int i =0; i<userIds.length; i++){
            if(set.contains(userIds[i])){
                continue;
            }
            
            if(isSuccess(userIds[i], banIds[depth])){
                set.add(userIds[i]);
                dfs(new HashSet(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }
    
    public boolean isSuccess(String userId, String banId){
        if(userId.length() != banId.length()){
            return false;
        }
        
        boolean flag = true;
        for(int i =0; i< banId.length(); i++){
            if(banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i)){
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}