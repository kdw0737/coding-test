import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static ArrayList<Integer> result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        result = new ArrayList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count=1;
                    findVilliage(i, j);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static void findVilliage(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if(y+dy[i]<N && y+dy[i]>=0 && x+dx[i]<N && x+dx[i]>=0 ){
                if(map[y+dy[i]][x+dx[i]]==1 && !visited[y+dy[i]][x+dx[i]]) {
                    findVilliage(y + dy[i], x + dx[i]);
                    count++;
                }
            }
        }
    }
}