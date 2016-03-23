package BinarySearch;

//LC 278
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2; // why not (start+end)/2, avoid possible overflow
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        return mid>5;
    }
}
