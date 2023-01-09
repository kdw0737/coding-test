import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int appleNum = Integer.parseInt(bf.readLine());
        int[] x= {1,0,-1,0};
        int[] y ={0,1,0,-1};
        Deque<int[]> deque = new ArrayDeque<>(); //뱀 위치정보 저장 덱 생성
        int[][] map = new int[N][N]; // 사과 위치 정보 담을 배열
        boolean[][] visited = new boolean[N][N]; // 현재 뱀의 몸통이 지도의 어디에 걸쳐있는지 저장
        int count = 0;

        //사과 위치 저장
        for(int i =0; i<appleNum; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        int directionNum = Integer.parseInt(bf.readLine());
        HashMap<Integer,String> directionInfo = new HashMap<>(); //방향정보 저장할 해시맵 ( key : 초, value: 방향 )
        //해시맵에 방향정보 저장
        for(int i =0; i<directionNum ; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            directionInfo.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        int nowDir =0; //현재 방향 인덱스로 표현
        deque.add(new int[]{0, 0}); //출발점
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
            //머리가 위치한곳이 사과인지 아닌지 체크, 사과인경우 0으로 만들어주고 아닌경우 몸통 길이 줄여줌
            if(map[headY][headX]!=1){
                int[] pos = deque.poll();
                visited[pos[0]][pos[1]] = false;
            }else
                map[headY][headX] = 0;
        }
        System.out.println(count+1);
    }
}