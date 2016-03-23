package Graph;


import java.util.*;

public class CloneGraphBFS {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            for (UndirectedGraphNode n : tmp.neighbors) {
                if (!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    queue.add(n);
                }
                map.get(tmp.label).neighbors.add(map.get(n.label));
            }
        }
        return clone;
    }
}
