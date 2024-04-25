import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Node[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Node[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = new Node(num, 0);
            }
        }
        st = new StringTokenizer(bf.readLine());
        int targetTime = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int timeCount = 1;
        while (timeCount <= targetTime) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].time == timeCount - 1 && arr[i][j].value != 0) {
                        for (int k = 0; k < 4; k++) {
                            int newX = j + dx[k];
                            int newY = i + dy[k];
                            if (newX < N && newX >= 0 && newY < N && newY >= 0) {
                                if (arr[newY][newX].value != 0) { // 이미 칸에 바이러스가 존재하는 경우
                                    if (arr[newY][newX].time == arr[i][j].time + 1) { // 생성 시간이 같은 경우
                                        if (arr[newY][newX].value < arr[i][j].value) { // 채워져있는 값이 더 작은 경우
                                            continue;
                                        } else {
                                            arr[newY][newX].value = arr[i][j].value;
                                        }
                                    } else { //이미 존재하는 바이러스 인 경우
                                        continue;
                                    }
                                } else { // 칸에 바이러스가 존재하지 않는 경우
                                    arr[newY][newX] = new Node(arr[i][j].value, arr[i][j].time + 1);
                                }
                            }
                        }
                    }
                }
            }
            timeCount++;
        }
        System.out.println(arr[targetY - 1][targetX - 1].value);
    }

    static class Node {
        int value;
        int time;

        public Node(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }

}
