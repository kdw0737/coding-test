import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isUsed = new boolean[N];

        backTracking(0,0);
        System.out.println(sb);
    }

    private static void backTracking(int start, int idx){
        if(idx==M){
            for(int num: arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =start; i<N; i++){
                arr[idx]=i+1;
                backTracking(i,idx+1);
            }
        }
    }
