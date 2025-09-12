class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;

        for (String tree : skill_trees) {
            int idx = 0;          
            boolean ok = true;

            for (int i = 0; i < tree.length(); i++) {
                char c = tree.charAt(i);

                // 해당 문자가 없으면 continue
                if (skill.indexOf(c) == -1) {
                    continue;
                }

                // skill 이 더 있는 경우 
                if (idx >= skill.length()) {
                    ok = false; 
                    break;
                }

                // 기대하는 문자가 아닌 경우
                if (c != skill.charAt(idx)) {
                    ok = false; 
                    break;
                }

                idx++;
            }

            if (ok) result++;
        }

        return result;
    }
}
