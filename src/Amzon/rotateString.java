package Amzon;

// is s2 a right rotate of s1
public class rotateString {
    public static int StringRightRotate(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) return -1;
        String s = s1 + s1;
        return s.indexOf(s2) > 0 ? 1 : -1;
    }
}
