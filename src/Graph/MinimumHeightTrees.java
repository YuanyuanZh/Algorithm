package Graph;


import java.util.*;

public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 1 || edges.length == 0 || edges[0].length <= 1) {
            List<Integer> rst = new ArrayList<Integer>();
            rst.add(0);
            return rst;
        }
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i: leaves) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if (graph.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
    //超时
    public static List<Integer> findMinHeightTreesDFS(int n, int[][] edges) {
        List<Integer> roots = new ArrayList<Integer>();
        if(n < 0) return roots;
        // covert the eddges to an adjacency list graph
        List<List<Integer>> graph =  new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        //count the height from each possible root and update the min height
        int mh = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            HashSet<Integer> visited =  new HashSet<Integer>();
            int h = helperMH(i, 0,  graph, visited);
            arr[i] = h;
            if (h < mh)
                mh = h;
        }
        for(int i= 0 ; i < n; i++){
            if(arr[i] == mh)
                roots.add(i);
        }
        return roots;
    }

    public static int helperMH(int root, int h, List<List<Integer>> edges, HashSet<Integer> visited) {
        visited.add(root);
        int max = h;
        for(int n: edges.get(root)){
            if(!visited.contains(n)) {
                int nh = helperMH(n, h+1, edges, visited);
                if(nh > max) max = nh;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] edge = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> rst = findMinHeightTrees(6,edge);
        List<Integer> rst2 = findMinHeightTreesDFS(6,edge);
        System.out.println(rst);
        System.out.println(rst2);
    }
}
