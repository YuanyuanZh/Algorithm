package Amzon.OA2;


import java.util.Comparator;
import java.util.PriorityQueue;

public class shortestJobFirst {
    public static class process {
        int arriveTime;
        int executeTime;

        process(int arriveTime, int executeTime) {
            this.arriveTime = arriveTime;
            this.executeTime = executeTime;
        }
    }

    // non-preempt
    //assume arrive is sorted by arrive time
    public static double shortestJobFirst(int[] arrive, int[] execute) {
        int finishedProcess = 0;
        boolean[] visited = new boolean[arrive.length];
        process cur = new process(arrive[0], execute[0]);
        int curTime = cur.arriveTime;
        int waitTime = 0;
        visited[0] = true;
        while (finishedProcess < arrive.length) {
            waitTime += curTime - cur.arriveTime;
            curTime += cur.executeTime;
            int shortest = Integer.MAX_VALUE;
            int shortestIndex = 0;
            for (int i = 0; i < arrive.length; i++) {
                if (!visited[i] && arrive[i] <= curTime) {////这个条件很重要
                    if (execute[i] < shortest) {
                        shortestIndex = i;
                        shortest = execute[i];
                    }
                }
            }
            if (shortest == Integer.MAX_VALUE) {
                if (finishedProcess == arrive.length - 1) break;
                else {
                    shortestIndex = finishedProcess + 1;
                    curTime = arrive[shortest];
                }
            }
            visited[shortestIndex] = true;
            cur = new process(arrive[shortestIndex], execute[shortestIndex]);
            finishedProcess++;
        }
        return (double) waitTime / arrive.length;
    }

    public static float Solution(int[] arrive, int[] execute) {
        if(arrive == null || execute == null || arrive.length != execute.length || arrive.length <= 1 || execute.length <= 1) return (float)0.0;
        int len = arrive.length;
        int curTime = arrive[0];
        int waitTime = 0;
        PriorityQueue<process> processPQ = new PriorityQueue<process>(new Comparator<process>(){
            @Override
            public int compare(process p1, process p2){
                if(p1.executeTime == p2.executeTime) return p1.arriveTime - p2.arriveTime;
                return p1.executeTime - p2.executeTime;
            }
        });
        int index = 1;
        processPQ.offer(new process(arrive[0], execute[0]));
        while(!processPQ.isEmpty()){
            process crtProcess = processPQ.poll();
            waitTime += curTime - crtProcess.arriveTime;
            curTime += crtProcess.executeTime;
            for(; index < len && arrive[index] <= curTime; ++index)
                processPQ.offer(new process(arrive[index], execute[index]));
        }
        return (float)waitTime / len;
    }

    public static void main(String[] args) {
        int [] arrive = {0,2,4};
        int [] execute ={5,3,3};
        System.out.println(shortestJobFirst(arrive,execute));
        System.out.println(Solution(arrive,execute));
    }

}