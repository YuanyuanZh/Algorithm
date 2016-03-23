package Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class CloneGraphDFS {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    public UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode n : node.neighbors) {
            clone.neighbors.add(clone(n));
        }
        return clone;
    }

    public UndirectedGraphNode cloneGraphIterative(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        stack.push(node);

        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();

            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, temp);
                    stack.push(neighbor);
                }
                map.get(cur.label).neighbors.add(map.get(neighbor.label));
            }
        }

        return root;
    }
}
