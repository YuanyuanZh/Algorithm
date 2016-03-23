package Amzon.OA2;

import java.util.LinkedList;

public class roundRobin {
    static class process {
        int arriveTime;
        int executeTime;

        process(int arriveTime, int executeTime) {
            this.arriveTime = arriveTime;
            this.executeTime = executeTime;
        }
    }

    public static double roundRobin(int[] arrive, int[] execute, int q) {
        LinkedList<process> queue = new LinkedList<process>();
        int curTime = 0;
        int waitTime = 0;
        int nextProIdx = 0;
        while (!queue.isEmpty() || nextProIdx < arrive.length) {
            if (!queue.isEmpty()) {
                process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += Math.min(cur.executeTime, q);
                for (int i = nextProIdx; i < arrive.length; i++) {
                    if (arrive[i] <= curTime) {
                        queue.offer(new process(arrive[i], execute[i]));
                        nextProIdx = i + 1;
                    } else {
                        break;
                    }
                }
                if (cur.executeTime > q) {
                    queue.offer(new process(curTime, cur.executeTime - q));
                }
            } else {
                queue.offer(new process(arrive[nextProIdx], execute[nextProIdx]));
                curTime = arrive[nextProIdx++];
            }
        }
        return (double) waitTime / arrive.length;
    }
    public static void main(String[] args) {
        int [] arrive = {0,1,3,9};
        int [] execute ={2,1,7,5};
        System.out.println(roundRobin(arrive,execute,2));
    }
}
