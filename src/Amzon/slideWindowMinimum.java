package Amzon;


import java.util.ArrayDeque;
import java.util.Deque;

public class slideWindowMinimum {
    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) return new int[0];
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();// remove numbers out of range k
            }
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();// remove smaller numbers in k range as they are useless
            }
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()]; // q contains index... r contains content
            }
        }
        return r;
    }

    public static int[] minSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) return new int[0];
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();//// remove numbers out of range k
            }
            while (!q.isEmpty() && a[q.peekLast()] > a[i]) {
                q.pollLast();//// remove larger numbers in k range as they are useless
            }
            q.offer(i);
            if (i >= k - 1) r[ri++] = a[q.peek()];
        }
        return r;
    }

    public static void main(String[] args) {
        int [] a1 ={1,3,-1,-3,5,3,6,7};
        int [] a = {4, 2, 12, 11, -5};
        int [] b = maxSlidingWindow(a,2);
        int [] b1 = minSlidingWindow(a1,3);
        for (int i = 0 ;i < b.length; i++) {
            System.out.println(b[i]);
        }
        for (int i = 0 ;i < b1.length; i++) {
            System.out.println(b1[i]);
        }
    }
}
