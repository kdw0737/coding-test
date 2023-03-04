import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> everyRoute;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        everyRoute = new ArrayList<>();
        int count =0;
        dfs("ICN","ICN",tickets,count);
        
        answer = Collections.min(everyRoute).split(" ");
        return answer;
    }
    
    private void dfs(String start, String route, String[][] tickets, int count){
        if(count==tickets.length){
            everyRoute.add(route);
            return;
        }
        for(int i =0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, count+1);
                visited[i] = false;
            }
        }
    }
}