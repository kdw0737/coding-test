import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i =0; i<num; i++){
            int a = sc.nextInt();
            int b = a/2;
            int c = a-b;
            while(!(isPrime(b)&&isPrime(c))){
                b-=1;
                c+=1;
            }
            System.out.println(b+" "+c);
        }
    }
    static boolean isPrime(int n){
        boolean check = true;
        for(int i =2; i<=Math.sqrt(n); i++){
            if(n%i==0)
                check = false;
        }
        return check;
    }
}
