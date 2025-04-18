import java.util.*;
class Solution {
    List<Set<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        // dfs로 조합 구하기 
        // set으로 길이 같은지 확인 
        
        for(int i = 1; i <= relation[0].length; i++){
            dfs(relation, i, 0, new ArrayList<>());
        }
        
        return candidateKeys.size();
    }
    
    public void dfs(String[][] arr, int limit, int depth, ArrayList<Integer> list){
        if(list.size() == limit){
            if(isUnique(arr, list) && isMinimal(list)){
                candidateKeys.add(new HashSet<>(list));
            }
            return;
        }
        
        for(int i = depth; i < arr[0].length; i++){
            list.add(i);
            dfs(arr, limit, i, list);
            list.remove(list.size() -1);
        }
    }
    
    // 유일성 체크
    public boolean isUnique(String[][] arr, ArrayList<Integer> list){
        HashSet<String> set = new HashSet<>();
        
        for(int i =0; i< arr.length; i++){
            String tmp = "";
            for(int n : list){
                tmp += arr[i][n];
            }
            set.add(tmp);
        }
        
        return set.size() == arr.length;
    }
    
    // 최소성 체크
    public boolean isMinimal(ArrayList<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        
        for(Set<Integer> key : candidateKeys){
            if(set.containsAll(key)){
                return false;
            }
        }
        return true;
    }
}