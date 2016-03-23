package Amzon;


import java.util.*;

public class KClosestPoints {
    static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class PointWithDis {
        Point p;
        double dis;
        PointWithDis(Point p, double dis) {
            this.p = p;
            this.dis = dis;
        }
    }
    public static List<Point> findKClosest(Point[] p, int k) {
        if (k <= 0) return new ArrayList<Point>();
        PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return (b.x * b.x + b.y * b.y) - (a.x * a.x + a.y * a.y);
            }
        });
        for (int i = 0; i < p.length; i++) {
            if (i < k)
                pq.offer(p[i]);
            else {
                Point temp = pq.peek();
                if ((p[i].x * p[i].x + p[i].y * p[i].y) - (temp.x * temp.x + temp.y * temp.y) < 0) {
                    pq.poll();
                    pq.offer(p[i]);
                }
            }
        }
        List<Point> x = new ArrayList<Point>();
        while (!pq.isEmpty())
            x.add(pq.poll());

        return x;
    }

    public static Point[] getCloseK(Point[] points, Point origin, int k){
        if (k <= 0) return new Point[0];
        PriorityQueue<PointWithDis> pq = new PriorityQueue<PointWithDis>(10, new Comparator<PointWithDis>() {
            @Override
            public int compare(PointWithDis a, PointWithDis b) {
                return (int) (b.dis - a.dis);
            }
        });

        PointWithDis[] pointWithDises =  new PointWithDis[points.length];
        int index = 0;
        for (Point p : points) {
            double dis = (p.x - origin.x)*(p.x - origin.x) + (p.y - origin.y)*(p.y - origin.y);
            pointWithDises[index++] = new PointWithDis(p,dis);
        }
        for (PointWithDis p : pointWithDises) {
            if (pq.size() < k) {
                pq.offer(p);
            }else {
                if (pq.peek().dis > p.dis){
                    pq.poll();
                    pq.offer(p);
                }
            }
        }
        Point[] res = new Point[k];
        index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll().p;
        }
        return res;
    }
    //O(n)
    public static Point[] getCloseK2(Point[] points, Point origin, int k) {
        if (k <= 0) return new Point[0];
        if (k >= points.length) return points;
        PointWithDis[] pointWithDises =  new PointWithDis[points.length];
        int index = 0;
        for (Point p : points) {
            double dis = (p.x - origin.x)*(p.x - origin.x) + (p.y - origin.y)*(p.y - origin.y);
            pointWithDises[index++] = new PointWithDis(p,dis);
        }
        selectionSort(pointWithDises);
        Point[] res = new Point[k];
        for (int i = 0; i < k; i++) {
            res[i] = pointWithDises[i].p;
        }
        return res;
    }

    public static void selectionSort (PointWithDis[] arr) {
        final Random random = new Random();
        for(int ind = 1; ind < arr.length; ind++) {
            final int r = random.nextInt(ind + 1);
            PointWithDis tmp = arr[ind];
            arr[ind] = arr[r];
            arr[r] = tmp;
        }
        selectionSort(arr, 0, arr.length-1);
    }

    public static void  selectionSort(PointWithDis[] arr, int lo, int hi) {
        if (lo > hi) return;
        int j = partition(arr,lo, hi);
        selectionSort(arr,lo, j-1);
        selectionSort(arr,j+1,hi);
    }

    public static int partition(PointWithDis[] a, int lo, int hi) {
        int i = lo;
        int j = hi;
        double key = a[lo].dis;
        while (i < j) {
            while (a[j].dis >= key && i< j) {
                j--;
            }
            while (a[i].dis <= key && i < j){
                i++;
            }

            PointWithDis tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        PointWithDis tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        return j;
    }

    public static void main(String[] args) {
        Point [] points = new Point[3];
        points[0] = new Point(-3,4);
        points[1] = new Point(1,1);
        points[2] = new Point(2,3);
        List<Point> r = findKClosest(points,2);
        Point[] p = getCloseK(points, new Point(0,0), 2);
        Point[] p2 = getCloseK2(points, new Point(0,0),2);
        System.out.println();
    }
}
