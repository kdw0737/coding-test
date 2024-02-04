import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public static void dfs(int k, int[][] dungeons, int depth){
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 아직 방문하지 않은 던전 중 피로도가 충분한 던전
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, depth + 1); // 다음 던전을 탐험하기 위해 재귀 호출
                visited[i] = false; // 백트래킹: 다른 경우를 탐색하기 위해 방문 표시 해제
            }
        }
    }
}