/*
Given a string s, return the longest palindromic substring in s.

Example 1:
  Input: s = "babad"
  Output: "bab"
  Note: "aba" is also a valid answer.
Example 2:
  Input: s = "cbbd"
  Output: "bb"
Example 3:
  Input: s = "a"
  Output: "a"
Example 4:
  Input: s = "ac"
  Output: "a"
Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters (lower-case and/or upper-case),
*/
class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;
        
        String result = s.substring(0, 1);
        
        for(int i = 0; i < s.length(); i++) {
            String temp = center(s, i, i);
            if (temp.length() > result.length()) {
                result = temp;
            }
            temp = center(s, i, i + 1);
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }
    
    private String center(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
