import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Long.valueOf(st.nextToken()));
        }
        for (int i = 0; i < M; i++) {
            long tmp = pq.poll() + pq.poll();
            pq.offer(tmp);
            pq.offer(tmp);
        }
        long sum =0;
        while (!pq.isEmpty()) {
            sum+=pq.poll();
        }
        System.out.println(sum);
    }
}