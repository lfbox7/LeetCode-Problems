/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"
Example 2:
  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I
Example 3:
  Input: s = "A", numRows = 1
  Output: "A"
Constraints:
    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000
*/
class Convert {
    public String convert(String s, int numRows) {

        // base case for quick return
        if (s.length() < 3 || numRows < 2 || s == null)
            return s;
        
        // create a list of StringBuilders based on numRows        
        List<StringBuilder> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }
        
        // variables for level and count => starts at -1 because level = 0
        int level = 0, count = -1;
        
        // break down the String into characters
        for (char c : s.toCharArray()) {
            // if the level is at 0 or the max, change count to +/- depending on level
            if (level == numRows - 1 || level == 0) 
                count *= -1;
            // append the character to the appropriate StringBuilder
            result.get(level).append(c);
            // increment or decrement level based on count polarity
            level += count;
        }
        // return the new String by using stream, map and collect to convert the StringBuilders to a String
        return result.stream().map(Object::toString).collect(Collectors.joining());
    }
}
