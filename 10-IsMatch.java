/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 
    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
Example 1:
  Input: s = "aa", p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".
Example 2:
  Input: s = "aa", p = "a*"
  Output: true
  Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:
  Input: s = "ab", p = ".*"
  Output: true
  Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:
  Input: s = "aab", p = "c*a*b"
  Output: true
  Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:
  Input: s = "mississippi", p = "mis*is*p*."
  Output: false
Constraints:
    0 <= s.length <= 20
    0 <= p.length <= 30
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
*/
class IsMatch {
    public boolean isMatch(String s, String p) {
        // use of helper method and recursion to answer problem
        return regex(s, p, 0, 0);
    }
    
    public boolean regex(String s, String p, int i, int j) {
        
        if (i >= s.length() && j >= p.length()) 
            return true;
        // find the asterisk to determine length of 3 char regex 
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            // if at this recursive iteration method returns true, return true
            if (regex(s, p, i, j + 2)) {
                return true;
            }
            // find the period to determine if wildcard
            if (p.charAt(j) == '.') {
                // iterate through the s String and if at a point the recursice iteration returns true, return true
                for (int k = i; k < s.length(); k++) {
                    if (regex(s, p, k + 1, j + 2)) {
                        return true;
                    }
                }
            } else {
                // iterate through the s String and if s at k and p at j are euqal and if at a point the recursice 
                // iteration returns true, return true
                for (int k = i; k < s.length(); k++) {
                    if (s.charAt(k) == p.charAt(j)) {
                        if (regex(s, p, k + 1, j + 2)) {
                            return true;
                            }
                    } else {
                        // break out of this for loop if not true to this point
                        break;
                    }
                }
            }
        // else if i and j stay less than s and p respectively and s at i and p at j ore equal or p at j is a period
        // return the results of i + 1 and j + 1
        } else if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            return regex(s, p, i + 1, j + 1);
        }
        // otherwise, return false
        return false;
    }
}
