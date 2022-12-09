import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i<N; i++){
            pq.offer(Integer.parseInt(bf.readLine()));
        }
        if(pq.size()==1){
            System.out.println(0);
            System.exit(0);
        }
        int sum =0;
        int count =0;
        while(pq.size()!=2){
            sum = pq.poll()+pq.poll();
            pq.offer(sum);
            count +=sum;
        }
        System.out.println(pq.poll()+pq.poll()+count);
    }
}