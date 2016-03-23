package String;


import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        char[] cs = s.toCharArray();
        if (cs.length % 2 != 0)
            return false;
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
}
