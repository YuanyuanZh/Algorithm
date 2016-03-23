package Array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) return;
        int rp = m + n;
        while (rp >= 0 && m >= 0 && n>= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[rp] = nums1[m];
                rp --;
                m--;
            }else {
                nums1[rp] = nums2[n];
                rp --;
                n--;
            }
        }
        while (rp >= 0 && m>=0) {
            nums1[rp] = nums1[m];
            rp --;
            m--;
        }
        while (rp >= 0 && n>=0) {
            nums1[rp] = nums2[n];
            rp --;
            n--;
        }
    }
}
