package Array;


public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (findKthElementOfTwoSortedArray(nums1,0,nums2,0,l) + findKthElementOfTwoSortedArray(nums1,0,nums2,0,r))/2;
    }

    public int findKthElementOfTwoSortedArray(int[] a, int aStart,int[] b, int bStart,  int k) {
        if (aStart > a.length - 1) return b[bStart + k - 1];
        if (bStart > b.length - 1) return a[aStart + k - 1];
        if (k == 1) return Math.min(a[aStart],b[bStart]);
        int aMid = Integer.MAX_VALUE;
        int bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 <= a.length-1) aMid = a[aStart + k/2 -1];
        if (bStart + k/2 - 1 <= b.length-1) bMid = b[bStart + k/2 -1];
        if (aMid < bMid) {
            return findKthElementOfTwoSortedArray(a, aStart + k/2, b, bStart, k - k/2);
        }
        else {
            return findKthElementOfTwoSortedArray(a, aStart, b, bStart + k/2, k - k/2);
        }
    }
}
