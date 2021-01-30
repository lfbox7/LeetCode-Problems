/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
Example 1:
    Input: nums = [2,2,1]
    Output: 1
Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4
Example 3:
    Input: nums = [1]
    Output: 1
Constraints:
    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
*/
class SingleNumber {
    public int singleNumber(int[] nums) {
        // create hashmap object
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // iterate through array
        for (int i = 0; i < nums.length; i++) {
            // if number is already in hashmap, change value to 2
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], 2);
            // add number to hashmap
            } else {
                map.put(nums[i], 1);
            }
        }
        // return result of getKey method of hashmap key with value of one
        return getKey(map, 1);
    } 
    
    // standard helper method to retrieve key with specific value
    public <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
