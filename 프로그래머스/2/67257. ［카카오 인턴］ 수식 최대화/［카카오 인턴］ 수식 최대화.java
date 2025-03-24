import java.util.*;

class Solution {

    String[] operator = {"+", "*", "-"};
    List<String> existOperators = new ArrayList<>();
    boolean[] visited;
    long answer = 0;
    int operatorNum = 0;
    List<Long> numList = new ArrayList<>();
    List<String> opList = new ArrayList<>();

    public long solution(String expression) {
        int idx = 0;

        // 숫자, 연산자 분리
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                opList.add(String.valueOf(ch));
                numList.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
            }
        }
        numList.add(Long.parseLong(expression.substring(idx)));

        // 실제 사용된 연산자만 추출
        for (int i = 0; i < operator.length; i++) {
            if (expression.contains(operator[i])) {
                existOperators.add(operator[i]);
            }
        }

        operatorNum = existOperators.size();
        visited = new boolean[operatorNum];
        dfs(new String[operatorNum], 0);

        return answer;
    }

    public void dfs(String[] tmp, int n) {
        if (n == operatorNum) {
            answer = Math.max(calculate(tmp), answer);
            return;
        }
        for (int i = 0; i < operatorNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[n] = existOperators.get(i);
                dfs(tmp, n + 1);
                visited[i] = false;
                tmp[n] = null;
            }
        }
    }

    public long calculate(String[] tmp) {
        List<Long> numListtmp = new ArrayList<>(numList);
        List<String> opListtmp = new ArrayList<>(opList);

        int now_op = 0;
        while (!opListtmp.isEmpty()) {
            if (opListtmp.contains(tmp[now_op])) {
                for (int i = 0; i < opListtmp.size(); i++) {
                    if (opListtmp.get(i).equals(tmp[now_op])) {
                        long a = numListtmp.remove(i);
                        long b = numListtmp.remove(i);
                        long res = calc(a, b, tmp[now_op]);
                        numListtmp.add(i, res);
                        opListtmp.remove(i);
                        break;
                    }
                }
            } else {
                now_op++;
            }
        }
        return Math.abs(numListtmp.get(0));
    }

    private long calc(long num1, long num2, String op) {
        if (op.equals("+")) {
            return num1 + num2;
        } else if (op.equals("-")) {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
