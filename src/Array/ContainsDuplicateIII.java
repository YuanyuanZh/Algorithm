package Array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
//todo 不是很懂
public class ContainsDuplicateIII {
/*
Bucketing means we map a range of values to the a bucket. For example, if the bucket size is 3,
we consider 0, 1, 2 all map to the same bucket. However, if t == 3, (0, 3) is a considered duplicates
but does not map to the same bucket. This is fine since we are checking the buckets immediately before
and after as well. So, as a rule of thumb, just make sure the size of the bucket is reasonable such that
elements having the same bucket is immediately considered duplicates or duplicates must lie within adjacent
buckets. So this actually gives us a range of possible bucket size, i.e. t and t + 1. We just choose it to
be t and a bucket mapping to be num / t.
Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0.
Therefore, we can just reposition every element to start from Integer.MIN_VALUE.
*/

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
//        for (int i=0; i<nums.length; i++) {
//            int j =0;
//            while (j<=t) {
//                if (hm.containsKey(nums[i]-j)) {
//                    if (Math.abs((i - hm.get(nums[i]-j)))<=k) return true;
//                }
//                j++;
//            }
//            hm.put(nums[i],i);
//        }
//        return false;
//    }
/*
This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result
 in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to
 simple queries can be executed both of time complexity O(lg K)
Here is the whole solution using TreeMap.
 */
//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length == 0 || k <= 0) {
//            return false;
//        }
//        final TreeSet<Integer> values = new TreeSet<Integer>();
//        for (int ind = 0; ind < nums.length; ind++) {
//            final Integer floor = values.floor(nums[ind] + t);
//            final Integer ceil = values.ceiling(nums[ind] - t);
//            if ((floor != null && floor >= nums[ind])
//                    || (ceil != null && ceil <= nums[ind])) {
//                return true;
//            }
//            values.add(nums[ind]);
//            if (ind >= k) {
//                values.remove(nums[ind - k]);
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] s = {2,2};
        System.out.println(containsNearbyAlmostDuplicate(s,3,0));
    }
}
