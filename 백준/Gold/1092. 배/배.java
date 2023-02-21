import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int craneNum = Integer.parseInt(bf.readLine());
        Integer[] craneWeightLimit = new Integer[craneNum];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < craneNum; i++) {
            craneWeightLimit[i] = Integer.parseInt(st.nextToken());
        }
        int boxNum = Integer.parseInt(bf.readLine());
        ArrayList<Integer> boxWeight = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < boxNum; i++) {
            boxWeight.add(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(craneWeightLimit, Collections.reverseOrder());
        Collections.sort(boxWeight, Collections.reverseOrder());
        if (craneWeightLimit[0] < boxWeight.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }
        int time = 0;
        while (!boxWeight.isEmpty()) {
            int craneIdx = 0;
            int boxIdx = 0;
            while (craneIdx < craneNum) {
                if (boxIdx == boxWeight.size()) {
                    break;
                } else if (craneWeightLimit[craneIdx] >= boxWeight.get(boxIdx)) {
                    boxWeight.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}