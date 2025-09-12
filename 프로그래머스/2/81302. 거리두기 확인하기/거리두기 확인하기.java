import java.util.*;

class Solution {
    static int y, x;
    static int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    static char[][] arr;
    static boolean[][] visited;
    static boolean flag;

    public int[] solution(String[][] places) {
        // 거리두기 지키면 1, 안 지키면 0
        int[] result = new int[places.length];
        int idx = 0;

        for (String[] tmp : places) {
            y = tmp.length; 
            x = tmp[0].length();

            // 맵 세팅 및 사람 좌표 수집
            List<int[]> people = new ArrayList<>();
            arr = new char[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    arr[i][j] = tmp[i].charAt(j);
                    if (arr[i][j] == 'P') people.add(new int[]{i, j});
                }
            }

            // 각 사람 좌표에서 DFS로 거리 2 이내 위반 여부 검사
            flag = true; // 전체 장소의 기본 상태: 준수(true)
            for (int[] pos : people) {
                visited = new boolean[y][x];      // 시작점마다 방문 배열 초기화
                dfs(pos[0], pos[1], 0);
                if (!flag) break;                 // 위반 발견 시 더 볼 필요 없음
            }

            result[idx++] = flag ? 1 : 0;
        }
        return result;
    }

    public static void dfs(int cy, int cx, int dist) {
        if (!flag) return;            // 이미 위반이면 불단락
        if (dist == 2) return;        // 거리 2에서 더 확장 금지 (맨해튼 2까지만 검사)

        visited[cy][cx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = cy + delta[i][0];
            int nx = cx + delta[i][1];

            // 범위 밖/재방문 금지
            if (!isIn(ny, nx) || visited[ny][nx]) continue;

            // 파티션이면 진행 불가
            if (arr[ny][nx] == 'X') continue;

            int nd = dist + 1;

            // 다음 칸이 사람이라면 거리 1~2 내 위반
            if (arr[ny][nx] == 'P') {
                flag = false;
                return;
            }

            // 빈칸이면 계속 탐색 (nd <= 2까지만)
            dfs(ny, nx, nd);
            if (!flag) return;        // 불단락
        }
    }

    public static boolean isIn(int cy, int cx) {
        return 0 <= cy && cy < y && 0 <= cx && cx < x;
    }
}
