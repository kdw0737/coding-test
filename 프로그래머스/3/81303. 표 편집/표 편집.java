import java.util.*;

class Solution {
    public String solution(int n, int k, String[] arr) {
        Node[] nodes = new Node[n];
        Stack<Node> deleted = new Stack<>();

        // 초기 노드 연결
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
                nodes[i - 1].next = nodes[i];
            }
        }

        Node cur = nodes[k];

        // 명령어 처리
        for (String str : arr) {
            char op = str.charAt(0);

            if (op == 'U' || op == 'D') {
                int num = Integer.parseInt(str.split(" ")[1]);
                for (int i = 0; i < num; i++) {
                    cur = (op == 'U') ? cur.prev : cur.next;
                }
            } else if (op == 'C') {
                deleted.push(cur);
                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;
                cur = (cur.next != null) ? cur.next : cur.prev;
            } else if (op == 'Z') {
                Node tmp = deleted.pop();
                if (tmp.prev != null) tmp.prev.next = tmp;
                if (tmp.next != null) tmp.next.prev = tmp;
            }
        }

        // 결과 문자열 생성
        char[] result = new char[n];
        Arrays.fill(result, 'O');
        while (!deleted.isEmpty()) {
            result[deleted.pop().idx] = 'X';
        }

        return new String(result);
    }

    class Node {
        int idx;
        Node prev, next;

        public Node(int idx) {
            this.idx = idx;
        }
    }
}
