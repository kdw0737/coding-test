class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        if(yellow == 1){
            return new int[]{3,3};
        }
        for(int i =1; i<= yellow/2; i++){
            int width = 0;
            int height = 0;
            if(yellow % i == 0){
                height = i;
                width = yellow/i;
            }
            if((height*2) + (width*2) +4 == brown){
                result[0] = width + 2;
                result[1] = height + 2;
                break;
            }
        }
        return result;
    }
}