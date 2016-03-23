package Array;

import java.util.ArrayList;
import java.util.List;

//Boyer-Moore Majority Vote algorithm
public class MajorityElements {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        int[] candicate = new int[2];
        int[] counter = new int[2];
        counter[0] = counter[1] = 0;
        candicate[0] = 0;
        candicate[1] = 1;

        for (int n : nums) {
            if (n == candicate[0]){
                counter[0]++;
            }
            else if ( n == candicate[1]) {
                counter[1]++;
            }
            else if (counter[0] == 0) {
                candicate[0] = n;
                counter[0] = 1;
            }
            else if (counter[1] == 0) {
                candicate[1] = n;
                counter[1] = 1;
            }
            else {
                counter[0]--;
                counter[1]--;
            }
        }
        counter[0]=counter[1]=0;
        for(int n: nums) {
            if (n == candicate[0]) counter[0]++;
            if (n == candicate[1]) counter[1]++;
        }
        for (int i = 0 ; i<2 ; i++) {
            if (counter[i] > nums.length/3) rst.add(candicate[i]);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = {3,2,2,3,3,3,3,4,4,4};
        System.out.println(majorityElement(a));
    }
}
