package Sort;


public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int l = 0; int r = nums.length-1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i,l++);
            }
            if (nums[i] == 2) {
                swap(nums, i, r--);
                i--;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i ==j ) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors2Pass(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0) count[0]++;
            if (nums[i] == 1) count[1]++;
            if (nums[i] == 2) count[2]++;
        }

        int y = 0;     // fixed part of array
        for (int color = 0; color < 3; ++color) {
            for (int i = 0; i < count[color]; ++i) {
                nums[y + i] = color;
            }
            y += count[color];
        }
    }
}
