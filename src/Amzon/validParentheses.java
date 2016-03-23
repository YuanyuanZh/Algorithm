package Amzon;


import java.util.Stack;

public class validParentheses {
    public static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : cs) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                switch (stack.pop()) {
                    case '(':
                        if (c != ')') return false;
                        break;
                    case '[':
                        if (c != ']') return false;
                        break;
                    case '{':
                        if (c != '}') return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

//给你一个str,里面只有 '('和‘)’,让你数valid pairs一共有多少,如果不是valid就返回-1.
// (判断是不是valid的parenthesis string，不是的话返回-1，是的话返回valid pair个数，即String.length() / 2 )
    public static int validPairs (String s) {
        if (s == null) return -1;
        char[] cs = s.toCharArray();
        if (cs.length %2 != 0) return -1;
        Stack<Character> stack = new Stack<Character>();
        for (char c : cs) {
            if (c == '(') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) return -1;
                stack.pop();
            }
        }
        return stack.isEmpty() ? s.length()/2 :-1;

    }

    public static void main(String[] args) {
        System.out.println(validPairs("(())()()"));
        System.out.println(validPairs("(()"));
        System.out.println(validPairs("("));
        System.out.println(validPairs(""));
        System.out.println(validPairs("(())()()*"));
    }
}
