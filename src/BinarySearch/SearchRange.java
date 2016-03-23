package BinarySearch;

//LC 34

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] rst = {-1,-1};
        if (nums == null || nums.length == 0) return rst;
        int lo = 0;
        int hi = nums.length-1;
        int mid = (lo + hi)/2;
        while (lo <= hi) {
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else {
                lo = mid;
                hi = mid;
                while (lo >= 0 && (nums[lo]==target)) {
                    rst[0] = lo;
                    lo--;
                }
                while (hi <= nums.length-1 && nums[hi]==target) {
                    rst[1] = hi;
                    hi++;
                }
                return rst;
            }
            mid = (lo + hi)/2;
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] r = searchRange(a,0);
        for (int i:r) {
            System.out.println(i);
        }
    }
}
