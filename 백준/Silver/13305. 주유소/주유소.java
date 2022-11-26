import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long[] oilPrice = new long[N];
        long[] distance = new long[N-1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N-1 ; i++){
            distance[i]= Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N-1; i++){
            oilPrice[i] = Long.parseLong(st.nextToken());
        }
        long minPrice = oilPrice[0];
        long sum = 0;
        for(int i =0; i<N-1; i++){
            if(minPrice>oilPrice[i])
                minPrice=oilPrice[i];
            sum+=minPrice*distance[i];
        }
        System.out.println(sum);
    }
}