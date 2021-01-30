/*

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
