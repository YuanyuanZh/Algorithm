package DP;


public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length(), max = 0;
        int[] matched = new int[n];
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == ')') {
                int left = right - 1 - matched[right - 1];
                if (left >= 0 && s.charAt(left) == '(') {
                    matched[right] = matched[right - 1] + 2;
                    if (left - 1 > 0)
                        matched[right] += matched[left - 1];
                }
            }
            max = Math.max(matched[right],max);
        }
        return max;
    }
}
