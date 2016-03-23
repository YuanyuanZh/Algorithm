package HashTable;

import java.util.HashMap;

//Examples:
//        pattern = "abba", str = "dog cat cat dog" should return true.
//        pattern = "abba", str = "dog cat cat fish" should return false.
//        pattern = "aaaa", str = "dog cat cat dog" should return false.
//        pattern = "abba", str = "dog dog dog dog" should return false.
public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            if (hm.containsKey(c)) {
                if (!words[i].equals(hm.get(c)))
                    return false;
            }else {
                if(hm.containsValue(words[i])) return false;
                hm.put(c, words[i]);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
}
