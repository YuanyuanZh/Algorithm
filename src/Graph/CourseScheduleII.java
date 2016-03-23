package Graph;


import java.util.*;

public class CourseScheduleII {
    public static int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = 0;
        int[] order = new int[numCourses];
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
            order[count++] = prere;
            for (Integer course: graph.get(prere)) {
                if (--indegree[course] == 0)
                    queue.offer(course);
            }
        }
        if(count == numCourses) {
            return order;
        }
        else {
            return new int[0];
        }
    }

    public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> grah = new ArrayList<List<Integer>>();
        
        for (int i = 0 ;i < numCourses; i++) {
            grah.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            grah.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int [] rst = new int[numCourses];
        boolean[] finished = new boolean[numCourses];
        boolean[] isVisited = new boolean[numCourses];
        Stack<Integer> sorted = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!finished[i] && !isVisited[i]) {
                dfs(grah, sorted,i ,finished,isVisited);
            }
        }
        if (sorted.size() == numCourses) {
            int index = rst.length-1;
            while (!sorted.isEmpty()) {
                rst[index--] = sorted.pop();
            }
            return rst;
        }else {
            return new int[0];
        }
    }

    public static void dfs(List<List<Integer>> grah, Stack<Integer> sorted, int i, boolean[] finished, boolean[] isVisited) {
        isVisited[i] = true;
        for (Integer course: grah.get(i)) {
            if (isVisited[course]) return;
            if (finished[course]) continue;
            dfs(grah,sorted,course,finished,isVisited);
        }
        finished[i] = true;
        isVisited[i] = false;
        sorted.push(i);
    }

    public static void main(String[] args) {
        int[][] course = {{1,0}};
        System.out.println(findOrderBFS(2,course));
    }
}
