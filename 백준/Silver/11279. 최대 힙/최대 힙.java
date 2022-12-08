import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> priorQue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            int input = Integer.parseInt(bf.readLine());
            if(input==0){
                if(priorQue.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(priorQue.poll()).append('\n');
            }
            else
                priorQue.offer(input);
        }
        System.out.println(sb);
    }
}