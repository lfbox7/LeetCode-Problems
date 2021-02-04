/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
  Input: x = 123
  Output: 321
Example 2:
  Input: x = -123
  Output: -321
Example 3:
  Input: x = 120
  Output: 21
Example 4:
  Input: x = 0
  Output: 0
Constraints:
  -231 <= x <= 231 - 1
*/
class Reverse {
    public int reverse(int x) {

        boolean negative = x < 0;
        
        int temp = Math.abs(x);
        long result = 0;
        
        while ( temp > 0) {
            result *= 10;
            result += temp % 10;
            temp /= 10;
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        
        return negative ? (int)-result : (int)result;
    }
}
