package Array;

//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length-1;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return j+1;
    }
}
