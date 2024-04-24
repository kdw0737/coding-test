import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<String> enter = new LinkedList<>();
        Queue<String> exit = new LinkedList<>();
        String[] arr = new String[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            enter.add(bf.readLine());
        }
        for (int i = 0; i < N; i++) {
            exit.add(bf.readLine());
        }
        while (!exit.isEmpty()) {
            String car = exit.poll();
            if (!enter.peek().equals(car)) {
                cnt++;
                enter.remove(car);
            } else {
                enter.poll();
            }
        }
        System.out.println(cnt);
    }
}
