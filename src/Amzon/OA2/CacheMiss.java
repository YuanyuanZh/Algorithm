package Amzon.OA2;


import java.util.ArrayList;
import java.util.List;

public class CacheMiss {
    public static int miss(int[] input, int size) {
        int res = 0;
        List<Integer> cache = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            int val = input[i];
            int pos = cache.indexOf(val);
            if (pos != -1) {
                cache.remove(pos);
                cache.add(val);
            }
            else {
                res ++;
                if (cache.size() == size) {
                    cache.remove(0);
                    cache.add(val);
                }
                else {
                    cache.add(val);
                }
            }
        }
        return res;
    }
}
