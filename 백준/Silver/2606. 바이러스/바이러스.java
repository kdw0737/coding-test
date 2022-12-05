import java.io.*;
import java.util.*;

public class Main {
    static int vertex, node;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int count =0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        node = Integer.parseInt(bf.readLine());
        vertex = Integer.parseInt(bf.readLine());
        for(int i =0; i<=node ; i++){
            list.add(new ArrayList<>());
        }
        for(int i =0; i<vertex ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        visited = new boolean[list.size()];
        bfs(1);
        System.out.println(count);
    }
    private static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()){
            int value = que.poll();
            visited[value] = true;
            for(int i =0; i<list.get(value).size(); i++){
                if(!visited[list.get(value).get(i)]){
                    visited[list.get(value).get(i)] = true;
                    que.offer(list.get(value).get(i));
                    count++;
                }
            }
        }
    }
}