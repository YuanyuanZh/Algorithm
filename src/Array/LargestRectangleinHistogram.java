package Array;


import java.util.Stack;

public class LargestRectangleinHistogram {

    //超时
    public static int largestRectangleAreaDP(int[] height) {
        if(height.length == 0) return 0;
        int max = 0;
        for(int i = 0; i < height.length; i++){
            int min = height[i];
            for(int j = i; j < height.length; j++) {
                min = Math.min(height[j],min);
                max = Math.max(max, min*(j-i+1));
            }
        }
        return max;
    }

    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                int tmp = height[tp] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, tmp);
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] height = {2,1,5,6,4,2};
        System.out.println(largestRectangleArea(height));
        System.out.println(largestRectangleAreaDP(height));
    }
}
