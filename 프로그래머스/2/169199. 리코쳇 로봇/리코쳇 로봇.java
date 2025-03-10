import java.util.*;

class Solution {
    int N, M;
    int[] dx = {-1, 1, 0, 0}; 
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[][] visit = new int[N][M];
        Queue<Point> q = new ArrayDeque<>();

        // 출발점 찾기
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i].charAt(j) == 'R') {
                    q.add(new Point(i, j));
                    visit[i][j] = 1;
                    break;
                }
            }
        }

        int answer = -1;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            // 목표 지점 도착 여부 확인
            if (board[cur.x].charAt(cur.y) == 'G') {
                answer = visit[cur.x][cur.y] - 1;
                break;
            }

            // 4방향 탐색
            for (int d = 0; d < 4; ++d) {
                int nextX = cur.x;
                int nextY = cur.y;

                // 이동 가능한 최대 거리까지 이동
                while (isInRange(nextX + dx[d], nextY + dy[d]) &&
                        board[nextX + dx[d]].charAt(nextY + dy[d]) != 'D') {
                    nextX += dx[d];
                    nextY += dy[d];
                }

                // 방문한 적이 없으면 큐에 추가
                if (visit[nextX][nextY] == 0) {
                    q.add(new Point(nextX, nextY));
                    visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
                }
            }
        }
        return answer;
    }

    public boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    class Point {
        int x, y;
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
