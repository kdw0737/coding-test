import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st ;
        int[][] point = new int[N][2];
        for(int i =0; i<N; i++){
            st=new StringTokenizer(bf.readLine());
            point[i][0]=Integer.parseInt(st.nextToken());
            point[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point, ((o1, o2) -> {
            if(o1[1]==o2[1])
                return Integer.compare(o1[0],o2[0]);
            else
                return Integer.compare(o1[1],o2[1]);
        }));
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            sb.append(point[i][0]+" "+point[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}