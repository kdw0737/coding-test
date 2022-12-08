import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> priorQue = new PriorityQueue<>();
        for(int i =0; i<N; i++){
            int input = Integer.parseInt(bf.readLine());
            if(input==0){
                if(priorQue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(priorQue.poll());
            }
            else
                priorQue.offer(input);
        }
    }
}