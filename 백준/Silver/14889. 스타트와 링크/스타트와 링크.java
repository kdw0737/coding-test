import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selectTeam(0,0);
        System.out.println(minDiff);
    }
    private static void selectTeam(int idx, int count){
        if(count==N/2) {
            diff();
            return;
        }

        for(int i=idx; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectTeam(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    private static void diff(){
        int startSum =0, linkSum =0;
        for(int i =0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i]==true && visited[j]==true){
                    startSum+=arr[i][j];
                    startSum+=arr[j][i];
                }
                if(visited[i]==false && visited[j]==false){
                    linkSum+=arr[i][j];
                    linkSum+=arr[j][i];
                }
            }
        }
        minDiff=Math.min(minDiff,Math.abs(startSum-linkSum));
    }
}