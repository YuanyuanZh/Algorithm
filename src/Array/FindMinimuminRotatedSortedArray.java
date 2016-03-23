package Array;

//[5,6,7,1,2,3,4]
//[6,7,1,2,3,4,5]
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[high];
    }
}
