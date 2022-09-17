import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N];
        int[] weight = new int[N];
        int[] place = new int[N];
        for(int i =0; i<N; i++){
            weight[i]=sc.nextInt();
            height[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            int rank =1;
            for(int j=0; j<N; j++){
                if(height[i]<height[j]&& weight[i]<weight[j]){
                    rank++;
                }
            }
            place[i]=rank;
        }
        for(int a:place)
            System.out.println(a);
    }
}