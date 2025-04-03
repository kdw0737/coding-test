import java.util.*;

class Solution {
    int result = 0;

    public int solution(int[] info, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);  

        backTracking(info, map, 0, 0, nextNodes);

        return result;
    }

    public void backTracking(int[] info, HashMap<Integer, ArrayList<Integer>> map,
                             int wolf, int sheep, List<Integer> nextNodes) {
        result = Math.max(result, sheep);  

        for (int i = 0; i < nextNodes.size(); i++) {
            int cur = nextNodes.get(i);
            int newSheep = sheep;
            int newWolf = wolf;

            if (info[cur] == 0) newSheep++;
            else newWolf++;

            if (newWolf >= newSheep) continue;  

            // 현재 노드를 방문했으니 다음 후보 리스트에서 제거
            List<Integer> newNext = new ArrayList<>(nextNodes);

            // 현재 노드에서 갈 수 있는 자식 노드를 다음 후보에 추가
            for (int child : map.getOrDefault(cur, new ArrayList<>())) {
                newNext.add(child);
            }
            
            newNext.remove(i);

            backTracking(info, map, newWolf, newSheep, newNext);
        }
    }
}
