class Solution {
    public String solution(int[] numbers, String hand) {
        // 이동거리 : (큰수 - 작은수) / 3 + (큰수 - 작은수) % 3 
        String result = "";
        int left = 10; // * 에 위치
        int right = 12; // # 에 위치
        for(int n : numbers){
            if(n == 1 || n == 4 || n == 7){
                result += "L";
                left = n;
            }else if(n == 3 || n == 6 || n == 9){
                result += "R";
                right = n;
            }else{ // 2 5 8 0 인 경우
                int cur = n;
                if(n == 0) cur = 11;
                int leftDist = (Math.abs(left-cur)) / 3 + (Math.abs(left-cur)) % 3;
                int rightDist = (Math.abs(right-cur)) / 3 + (Math.abs(right-cur)) % 3;
                if(leftDist < rightDist){
                    // 왼손이 더 가까운경우
                    result += "L";
                    left = cur;
                }else if(leftDist > rightDist){
                    // 오른손이 더 가까운경우
                    result += "R";
                    right = cur;
                }else{
                    // 둘이 거리가 같은 경우
                    if(hand.equals("right")){
                        result += "R";
                        right = cur;
                    }
                    if(hand.equals("left")){
                        result += "L";
                        left = cur;
                    }
                }
            }
        }
        return result;
    }
}