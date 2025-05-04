import java.util.*;
class Solution {
    static int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
    public int solution(int[][] board) {
        // 직선 : 100원 , 코너 : 500원
        // 건설 최소 비용 return
        // 0 : 길 , 1 : 벽
        // dir 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
        
        int[][] visited = new int[board.length][board.length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,0,100));
        q.add(new Node(0,0,1,100));
        visited[0][0] = 100;
        int result = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            if(node.cy == board.length - 1 && node.cx == board.length - 1){
                result = Math.min(result, node.cost);
            }
            
            for(int i =0; i<4; i++){
                // 역방향이면 pass
                if((i + 2) % 4 == node.dir) continue;
                
                int ny = node.cy + delta[i][0];
                int nx = node.cx + delta[i][1];
                
                if(isIn(board, ny, nx) && board[ny][nx] != 1){
                    int weight = node.dir == i ? 100 : 600;
                    if(visited[ny][nx] == 0){
                        // 처음 방문한 경우
                        visited[ny][nx] = node.cost + weight;
                        q.add(new Node(ny, nx, i, node.cost + weight));
                    }else if(node.cost + weight < visited[ny][nx] + 500){
                        // 이미 방문한 적 있는 경우
                        visited[ny][nx] = node.cost + weight;
                        q.add(new Node(ny, nx, i, node.cost + weight));
                    }
                }
            }
        }
        return result - 100;
    }
    
    static boolean isIn(int[][] board, int y, int x){
        return 0 <= y && y < board.length && 0 <= x && x < board.length;
    }
    
    static class Node{
        int cy;
        int cx;
        int dir;
        int cost;
        
        public Node(int cy, int cx, int dir, int cost){
            this.cy = cy;
            this.cx = cx;
            this.dir = dir;
            this.cost = cost;
        }
    }
}