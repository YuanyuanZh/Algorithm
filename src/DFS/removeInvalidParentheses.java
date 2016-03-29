package DFS;


import java.util.*;

public class removeInvalidParentheses {
    //DFS
    public static List<String> removeParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        int rmL = 0;
        int rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') rmL++;
            if (s.charAt(i) == ')') {
                if (rmL != 0) rmL--;
                else rmR++;
            }
        }
        dfs(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    public static void dfs(Set<String> res, String s, int index, int rmL, int rmR, int open, StringBuilder sb) {
        if (index == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (index == s.length() || rmL < 0 || rmR < 0 || open < 0)
            return;
        char c = s.charAt(index);
        if (c == '(') {
            dfs(res, s, index + 1, rmL - 1, rmR, open, sb);
            dfs(res, s, index + 1, rmL, rmR, open + 1, sb.append(c));
        } else if (c == ')') {
            dfs(res, s, index + 1, rmL, rmR - 1, open, sb);
            dfs(res, s, index + 1, rmL, rmR, open - 1, sb.append(c));
        } else {
            dfs(res, s, index + 1, rmL, rmR, open, sb.append(c));
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    //BFS
    public static List<String> removeParenthesesBFS(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isVaild(s)) {
                res.add(s);
                found = true;
            }
            if (found) continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String newString = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(newString)) {
                    queue.add(newString);
                }
            }
        }
        return res;
    }
//    public static List<String> removeParentheses(String s) {
//        Set<String> res = new HashSet<>();
//        int rmL = 0, rmR = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') rmL++;
//            if (s.charAt(i) == ')') {
//                if (rmL != 0) {
//                    rmL--;
//                }else rmR++;
//            }
//        }
//        dfs(res, s, 0, rmL, rmR,0,new StringBuilder());
//        return new ArrayList<String>(res);
//    }
//
//    public static void dfs(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
//        if (i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
//            res.add(sb.toString());
//            return;
//        }
//        if (i == s.length() || rmL < 0 ||rmR < 0|| open < 0) return;
//        char c = s.charAt(i);
//
//        if (c == '(') {
//            dfs(res, s, i+1, rmL-1, rmR, open, sb);
//            dfs(res, s, i+1, rmL, rmR, open+1, sb.append(c));
//        }
//        else if (c == ')') {
//            dfs(res, s, i+1, rmL, rmR-1, open, sb);
//            dfs(res, s, i+1, rmL, rmR, open-1, sb.append(c));
//        }
//        else {
//            dfs(res, s, i+1, rmL, rmR, open, sb.append(c));
//        }
//        sb.deleteCharAt(sb.length()-1);
//    }

    public static List<String> removeParentheses2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        boolean found = false;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            if (isVaild(s)) {
                res.add(s);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
                String t = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    public static boolean isVaild(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(removeParentheses("()())()"));
    }
}
