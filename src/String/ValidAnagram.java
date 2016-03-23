package String;


public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] count = new int['z'-'a'+1];
        for (char c: s.toCharArray()) {
            count[c-'a']++;
        }
        for (char c :t.toCharArray()) {
            count[c-'a']--;
        }
        for (int i=0; i<count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat","cat"));
    }
}
