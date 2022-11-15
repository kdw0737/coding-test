class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row, column;
        row = column = 1;
        for(int i =1; i<=Math.sqrt(yellow); i++){
            column = i;
            if(yellow%i==0){
                row = yellow/column;
                if(yellow+brown==(row+2)*(column+2)){
                    answer[0]=row+2;
                    answer[1]=column+2;
                }
            }
        }
        return answer;
    }
}