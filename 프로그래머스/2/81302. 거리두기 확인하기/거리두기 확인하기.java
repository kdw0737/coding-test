import java.util.*;
class Solution {
    static int y, x;
    static int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static char[][] arr;
    static boolean[][] visited;
    static boolean flag;

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        int idx = 0;

        for (String[] tmp : places) {
            y = tmp.length; 
            x = tmp[0].length();
            arr = new char[y][x];

            List<int[]> people = new ArrayList<>();
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    arr[i][j] = tmp[i].charAt(j);
                    if (arr[i][j] == 'P') people.add(new int[]{i, j});
                }
            }

            flag = true; 

            // 사람마다 독립 BFS
            for (int[] p : people) {
                if (!bfsOne(p[0], p[1])) { 
                    flag = false;
                    break;
                }
            }

            result[idx++] = flag ? 1 : 0;
        }
        return result;
    }

    public static boolean bfsOne(int sy, int sx) {
        visited = new boolean[y][x];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx, 0});
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0], cx = cur[1], d = cur[2];

            if (d == 2) continue; 

            for (int i = 0; i < 4; i++) {
                int ny = cy + delta[i][0];
                int nx = cx + delta[i][1];
                
                if (!isIn(ny, nx) || visited[ny][nx]) continue;
                if (arr[ny][nx] == 'X') continue; 

                int nd = d + 1;

                if (arr[ny][nx] == 'P') {
                    return false;
                }

                if (nd <= 2) {
                    visited[ny][nx] = true;   
                    q.offer(new int[]{ny, nx, nd});
                }
            }
        }
        return true; 
    }

    public static boolean isIn(int cy, int cx) {
        return 0 <= cy && cy < y && 0 <= cx && cx < x;
    }
}
