import java.io.*;
import java.util.*;

public class Main {
    static int[] x= {1,0,-1,0};
    static int[] y ={0,1,0,-1};
    static boolean[][] visited;
    static int[][] map;
    static Deque<int[]> deque = new ArrayDeque<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int appleNum = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i =0; i<appleNum; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        int directionNum = Integer.parseInt(bf.readLine());
        HashMap<Integer,String> directionInfo = new HashMap<>();
        for(int i =0; i<directionNum ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            directionInfo.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        int nowDir =0;
        deque.add(new int[]{0, 0});
        while(true){
            if(directionInfo.containsKey(count)){
                if(directionInfo.get(count).equals("D")) {
                    nowDir++;
                    if(nowDir==4)
                        nowDir=0;
                }
                else{
                    nowDir--;
                    if(nowDir==-1)
                        nowDir=3;
                }
            }
            int headX = deque.getLast()[1]+x[nowDir];
            int headY = deque.getLast()[0] + y[nowDir];
            if(headY>=0 && headY<N && headX>=0 && headX<N) {
                if(!visited[headY][headX]) {
                    deque.add(new int[]{headY, headX});
                    visited[headY][headX] = true;
                    count++;
                }else
                    break;
            }else
                break;
            if(map[headY][headX]!=1){
                int[] pos = deque.poll();
                visited[pos[0]][pos[1]] = false;
            }else
                map[headY][headX] = 0;
        }
        System.out.println(count+1);
    }
}