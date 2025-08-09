import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String, Integer> vis = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        char[] choice = {'A', 'C', 'G', 'T'};
        q.add(startGene);
        vis.put(startGene, 0);

        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.equals(endGene)) {
                return vis.get(s);
            }
            int level = vis.get(s);
            for (int pos = 0; pos < s.length(); pos++) {
                for (char c : choice) {
                    if (c == s.charAt(pos)) continue;
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(pos, c);
                    String s1 = sb.toString();
                    if (searchBank(s1, bank) && !vis.containsKey(s1)) {
                        vis.put(s1, level + 1);
                        q.add(s1);
                    }
                }
            }
        }
        return -1;
    }

    public boolean searchBank(String str, String[] bank) {
        for (String b : bank) {
            if (b.equals(str)) return true;
        }
        return false;
    }
}
