import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashMap<String, Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        char[] alphabets = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };
        
        for (int i = 0; i < n; i++) {
            hs.add(wordList.get(i));
        }
        
        q.add(beginWord);
        hm.put(beginWord, 1);
        
        while (q.size() > 0) {
            String s = q.poll();
            int level = hm.get(s);
            
            if (s.equals(endWord)) {
                return level;
            }
            
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    if (s.charAt(i) == alphabets[j]) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, alphabets[j]);
                    String s1 = sb.toString();
                    
                    if (hs.contains(s1) && !hm.containsKey(s1)) {
                        hm.put(s1, level + 1);
                        q.add(s1);
                    }
                }
            }
        }
        return 0;
    }
}
