package String;

import java.util.*;

/*
["eat", "tea", "tan", "ate", "nat", "bat"]
{"aet": ["eat","tea","ate"]
 "ant": ["tan","nat"]
 "abt": ["bat"]
}
*/

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> rst = groupAnagrams(strs);
        System.out.println(rst);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    }
}
