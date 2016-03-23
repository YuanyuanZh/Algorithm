package BinarySearch;


public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int min = findMin(nums);
        if (target == nums[min]) return min;
        int lo;
        int hi;
        if (min == 0){
            lo = 0;
            hi = nums.length-1;
        }
        else if (target >= nums[0] && target <= nums[min-1]){
            lo = 0;
            hi = min;

        }else if (target > nums[min] && target <= nums[nums.length-1]){
            lo = min+1;
            hi = nums.length-1;
        }
        else
            return -1;
        int  mid = lo + (hi-lo)/2;
        while (lo < hi) {
            if (nums[mid] == target){return mid;}
            else if (nums[mid] > target) hi = mid-1;
            else lo = mid +1;
            mid = lo + (hi-lo)/2;
        }
        return nums[lo] == target ? lo:-1;
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[high] < nums[mid]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
