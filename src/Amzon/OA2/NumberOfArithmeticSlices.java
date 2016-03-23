package Amzon.OA2;

// A = {-1,1,3,3,3,2,1,0} => 5 (0 2) (2 4) (4 6) (4 7) (5 7)

public class NumberOfArithmeticSlices {
    public static int getLAS(int[] A) {
        if (A == null || A.length < 3) return 0;
        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int s= 0;
        for (int i = 1; i < A.length; i++) {
            int curDiff = A[i] - A[i-1];
            if (diff == curDiff) {
                count += i-s-1 > 0? i-s-1:0;
            }
            else {
                s = i-1;
                diff = curDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        return res;
    }

    public static int find(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int left = 0;
        int right = 1;
        int diff = nums[1] - nums[0];
        int cnt = 0;
        while (right < nums.length - 1) {
            if (diff != nums[right + 1] - nums[right]) {
                cnt += (right - left - 1) * (right - left) / 2;
                if (cnt > 1000000000) {
                    return -1; }
                diff = nums[right + 1] - nums[right];
                left = right;
            }
            right++;
        }
        cnt += (right - left - 1) * (right - left) / 2;
        return cnt > 1000000000 ? -1 : cnt;
    }

    public static void main(String[] args) {
        int[] a = {-1,1,3,3,3,2,1,0};
        int[] arr = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
        int[] a1 = {-1,1,3,3,3,2,1,0};
        int[] arr1 = {2,5,2,3,4,6,8,10,12,9,8,7,6,2,4,8};
        System.out.println(getLAS(a));
        System.out.println(getLAS(arr));
        System.out.println(find(a1));
        System.out.println(find(arr1));
    }
}
