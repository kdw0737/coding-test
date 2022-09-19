import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(bf.readLine());
        System.out.println(Math.PI*N*N);
        System.out.println(2*N*N);
    }
}