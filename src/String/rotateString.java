package String;


public class rotateString {
    //判断string1和string2是否互为right rotation。比如：abcd和cdab
    //First make sure s1 and s2 are of the same length. Then check to see if s2 is a substring of s1 concatenated with s1:
    public boolean isRotateString (String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        String contect = s + s;
        return contect.contains(t);
    }
}
