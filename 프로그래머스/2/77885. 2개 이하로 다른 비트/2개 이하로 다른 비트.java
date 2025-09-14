class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if ((n & 1L) == 0L) {           // 짝수인 경우
                result[i] = n + 1;
            } else {                        // 홀수인 경우
                long bit = (~n) & (n + 1);  
                result[i] = n + bit - (bit >>> 1);  
            }
        }
        return result;
    }
}