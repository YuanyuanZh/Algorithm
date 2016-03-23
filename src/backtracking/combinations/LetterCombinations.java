package backtracking.combinations;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return rst;
        helper(rst, new StringBuilder(), digits, 0);
        return rst;
    }

    public static void helper(List<String> rst, StringBuilder sub, String digits, int index) {
        if (sub.length() == digits.length()) {
            rst.add(sub.toString());
            return;
        }
        String tmp = map[digits.charAt(index) - '0'];
        for (int i = 0; i < tmp.length(); i++) {
            sub.append(tmp.charAt(i));
            helper(rst, sub, digits, index + 1);
            sub.deleteCharAt(sub.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
