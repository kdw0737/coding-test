import java.io.*;
import java.util.*;

public class Main {
    static int N,answer =0;
    static int[] time,price;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        time = new int[N];
        price = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,answer);
        System.out.println(answer);
    }

    private static void dfs(int idx, int money){
        if(idx > N-1){
            answer = Math.max(money , answer);
            return;
        }
        if(idx+time[idx]<=N)
            dfs(idx+time[idx],money+ price[idx]);
        else
            dfs(idx+time[idx],money);
        dfs(idx+1,money);
    }
}