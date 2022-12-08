import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> priorQue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()) {
                priorQue.offer(Integer.parseInt(st.nextToken()));
            }
        };
        for(int i =0; i<N-1; i++)
            priorQue.poll();
        System.out.println(priorQue.poll());
    }
}