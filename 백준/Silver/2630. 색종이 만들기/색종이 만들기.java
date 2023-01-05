import java.io.*;
import java.util.*;

public class Main {
    static int N, white=0, blue=0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for(int i =0; i<N; i++){
            StringTokenizer st= new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        devideArea(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void devideArea(int x, int y, int size){
        if(colorCheck(x,y,size)){
            if(arr[y][x]==0)
                white++;
            else
                blue++;
            return;
        }
        size/=2;
        devideArea(x, y,size);
        devideArea(x, y+size,size);
        devideArea(x+size,y,size);
        devideArea(x+size,y+size,size);
    }
    private static boolean colorCheck(int x, int y, int size){
        int check = arr[y][x];
        for(int i =y; i<y+size; i++){
            for(int j =x; j<x+size; j++){
                if(check != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}

