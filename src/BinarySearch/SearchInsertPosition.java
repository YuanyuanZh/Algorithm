package BinarySearch;

//LC 35
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        int lo = 0;
        int hi = len-1;
        int mid = (lo+hi)/2;
        while (lo <= hi) {
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) hi = mid-1;
            else if (target > nums[mid]) lo = mid+1;
            mid = (lo+hi)/2;
        }
        return lo;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= target)
//                return i;
//        }
//        return nums.length;
    }

    public static void main(String[] args) {
        int[] a= {1,3,5,6};
        System.out.println(searchInsert(a,8));
    }
}
