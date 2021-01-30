/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring
Example 4:
    Input: s = ""
    Output: 0
Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
*/
class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        // base case is string is null or 0 char
        if (s == null || s.length() == 0)
            return 0;

        // create hashset objectt
        HashSet<Character> set = new HashSet<>();

        // variables
        // result will be Math.max
        int result = 0;
        int count = 0;

        // loop to fill the hashset
        for (int i = 0; i < s.length(); i++ ) {
        //keeping track of longest substring
        char temp = s.charAt(i);
        if(!set.contains(temp)) {
            set.add(temp);
            result = Math.max(result, set.size());
        } else {
            while (count < i) {
            if (s.charAt(count) == temp) {
                count++;
                break;
            }
            set.remove(s.charAt(count));
            count++;
        }
      }
    }
    // return int result of length of substring
    return result;
  }
}
