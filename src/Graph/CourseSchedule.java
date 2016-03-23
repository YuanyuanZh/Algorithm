package Graph;

import java.util.*;

public class CourseSchedule {

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0], prere = prerequisites[i][1];
            indegree[course]++;
            graph.get(prere).add(course);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer prere = queue.poll();
            count++;
            for (Integer course: graph.get(prere)) {
                if (--indegree[course] == 0)
                    queue.offer(course);
            }
        }
        return count == numCourses;
    }
    public boolean canFinishDFS(int num, int[][] pre) {

        //transfer the list of edges representation to adjacency list
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < num; i++){
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < pre.length; i++) {
            int[] pair = pre[i];
            graph.get(pair[0]).add(pair[1]);
        }
        //boolean array to record whether we have returned from that course/node, or whether it can be finished
        boolean[] finished = new boolean[num];
        //another boolean array to record whether nodes are on the finishing path
        boolean[] visited =  new boolean[num];
        //use a stack to push the finished course in reverse order
        //   Stack<Integer> sorted = new Stack<Integer>();
        for (int i = 0; i < num; i++) {
            if (!finished[i] && !visited[i])
                dfs(i, graph, finished, visited);
        }

        for (int i = 0; i < num; i++){
            if(!finished[i])
                return false;
        }
        return true;
    }

    public void dfs(int i, List<List<Integer>> graph, boolean[] finished, boolean[] visited) {
        List<Integer> neighbors = graph.get(i);
        visited[i] = true;
        for(int n : neighbors){
            if(visited[n])
                return;
            if(finished[n])
                continue;
            dfs(n, graph, finished, visited);
        }
        finished[i] = true;
        visited [i] = false;//pop out i on path
        // stack.push(i);
    }
}
