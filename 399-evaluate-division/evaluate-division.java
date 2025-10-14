import java.util.*;

class pair {
    String destination;
    double div;

    pair(String destination, double div) {
        this.destination = destination;
        this.div = div;
    }

    public String getdestination() {
        return destination;
    }

    public double getdiv() {
        return div;
    }
}

class Solution {
    double ans; // changed from int to double

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<pair>> hm = new HashMap<>();
      
        double[] calc = new double[queries.size()]; 

        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);

            if (!hm.containsKey(s1)) {
                hm.put(s1, new ArrayList<>());
            }
            if (!hm.containsKey(s2)) {
                hm.put(s2, new ArrayList<>());
            }
            hm.get(s1).add(new pair(s2, values[i]));
            hm.get(s2).add(new pair(s1, 1.0 / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> arr = queries.get(i); // fixed type
            if (!hm.containsKey(arr.get(0))) {
                calc[i] = -1.0;
            } else {
                ans = -1.0;
                HashSet<String> hs = new HashSet<>(); // fixed type
                dfs(hm, arr.get(0), 1.0, arr.get(1), hs); // fixed method call
                calc[i] = ans;
            }
        }

        return calc;
    }

    public void dfs(HashMap<String, List<pair>> hm, String curr, double currdiv, String end, HashSet<String> hs) {
        if (hs.contains(curr)) {
            return;
        }
        if (curr.equals(end)) { 
            ans = currdiv;
            return;
        }
        hs.add(curr);
        for (pair p : hm.get(curr)) {
            dfs(hm, p.getdestination(), currdiv * p.getdiv(), end, hs);
        }
                   

    }
}

