package support;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Integer, Integer> parents;

    public UnionFind(int n) {
        parents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parents.put(i, i);
        }
    }

    public int find(int x) {
        int ans = x;
        while (ans != parents.get(ans)) {
            ans = parents.get(ans);
        }
        while (x != ans) {
            int parent = parents.get(x);
            parents.put(x, ans);
            x = parent;
        }
        return ans;
    }

    public void union(int x, int y) {
        parents.put(find(x), find(y));
    }
}
