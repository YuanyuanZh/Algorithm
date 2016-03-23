package DP;

//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "a*") → true
//isMatch("aa", ".*") → true
//isMatch("ab", ".*") → true
//isMatch("aab", "c*a*b") → true

//1) p == null check is if s == null
//1) p.len == 1 || p(1) != * check (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0)) then isMatch(s.substring(1), p.substring(1))
//2) p(1) == "*" (abb - a*bb or a*abb)
//   - !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') , isMatch(s, p.substring(2)
//  -  isMatch(s, p.substring(2));
public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // p.length == 1 || P.length() >=2 && p.charAt(1) != *
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >=2 && p.charAt(1) == * && (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa",".*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aaca", "ab*a*c*a"));
    }
}
