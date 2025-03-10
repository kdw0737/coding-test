import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 하다가 멈춘건 stack에 저장
        // 새로 시작해야 되는건 pq에 시간순으로 저장
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        Stack<Node> stack = new Stack<>();
        String[] result = new String[plans.length];
        int idx = 0;

        for (String[] plan : plans) {
            que.add(new Node(plan[0], plan[1], plan[2]));
        }

        while (!que.isEmpty()) {
            Node node = que.poll();
            int endTime = node.start + node.duration;

            if (!que.isEmpty() && endTime > que.peek().start) {
                // 현재 과제가 끝나기 전에 다음 과제가 시작된다면 멈춤
                int remain = node.duration - (que.peek().start - node.start);
                stack.push(new Node(node.sub, remain));
            } else {
                // 현재 과제가 끝나고 다음 과제 시작 전이라면 완료
                result[idx++] = node.sub;
                int now = endTime;

                while (!stack.isEmpty()) {
                    Node cont = stack.pop();
                    if (!que.isEmpty() && now + cont.duration > que.peek().start) {
                        // 다음 과제가 시작되면 다시 멈춰야 함
                        int remain = cont.duration - (que.peek().start - now);
                        stack.push(new Node(cont.sub, remain));
                        break;
                    }
                    result[idx++] = cont.sub;
                    now += cont.duration;
                }
            }
        }

        // 스택에 남아 있는 과제 마저 처리
        while (!stack.isEmpty()) {
            result[idx++] = stack.pop().sub;
        }

        return result;
    }

    public static class Node {
        String sub;
        int start;
        int duration;

        public Node(String sub, String time, String l) {
            String[] arr = time.split(":");
            int start = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            this.sub = sub;
            this.start = start;
            this.duration = Integer.parseInt(l);
        }

        public Node(String sub, int remain) {
            this.sub = sub;
            this.duration = remain;
        }
    }
}
