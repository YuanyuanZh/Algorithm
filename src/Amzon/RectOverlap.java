package Amzon;


public class RectOverlap {
    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y; }
    }
    // rectangle A, B
    // time O(1), space O(1)
    public static boolean check(Node l1, Node l2, Node r1, Node r2) {
        // if one rectangle is above other
        if (r1.y >= l2.y || r2.y >= l1.y) {
            return false;
        }
        //if one rectangle is on left side of other
        if (l1.x >= r2.x || l2.x >= r1.x) {
            return false;
        }
        return true;
    }

    public static int  AreaComputer(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = Math.abs((C-A)*(D-B));
        int areaB = Math.abs((G-E)*(H-F));
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(B,F);
        int bottom = Math.max(D,H);
        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaA + areaB - overlap;
    }

    public static void main(String[] args) {
        Node A = new Node(0,4);
        Node A1 = new Node(4,0);
        Node B = new Node(3,7);
        Node B1 = new Node(7,3);
        Node C = new Node(4,8);
        Node C1 = new Node(8,4);
        System.out.println(check(A,B,A1,B1));
        System.out.println(check(A,C,A1,C1));
        System.out.println(AreaComputer(0,4,4,0,3,7,7,3));
        System.out.println(AreaComputer(0,4,4,0,4,8,8,4));
    }

}
