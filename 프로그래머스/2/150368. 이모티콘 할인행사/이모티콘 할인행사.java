import java.util.*;
class Solution {
    int[] disc = {10,20,30,40};
    int[][] users;
    int[] emoticons;
    int[] result = new int[2]; 
    public int[] solution(int[][] user, int[] emoticon) {
        // users : [비율, 가격]
        // 서비스 가입자 최대 + 이모티콘 판매액 최대
        // return : [서비스 가입자 수, 매출액]
        
        users = user;
        emoticons = emoticon;
        
        dfs(0, new ArrayList<Integer>());
        
        return result;
    }
    
    public void dfs(int depth, ArrayList<Integer> discList){
        if(depth == emoticons.length){
            calcCost(discList);
            return;
        }
        
        for(int i = 0; i < disc.length; i++){
            discList.add(disc[i]);
            dfs(depth + 1, discList);
            discList.remove(discList.size() - 1);
        }
    }
    
    public void calcCost(ArrayList<Integer> discList){
        int[] arr = new int[users.length];
        int total = 0;
        int service = 0;
        
        for(int i =0; i< users.length; i++){
            int sum = 0;
            for(int j =0; j< emoticons.length; j++){
                if(discList.get(j) >= users[i][0]){
                    // 일정 비율 이상 할인하는 이모티콘인 경우
                    sum += emoticons[j] * (100 - discList.get(j)) / 100;
                }
            }
            
            if(sum >= users[i][1]){
                // 기준 금액이 넘는다면 서비스로 변경
                service++;
            }else{
                total += sum;
            }
        }
        
        if(result[0] < service){
            result[0] = service;
            result[1] = total;
        }
        
        if(result[0] == service){
            if(result[1] < total) result[1] = total;
        }
    }
}