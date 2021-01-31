/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Follow up: The overall run time complexity should be O(log (m+n)).
Example 1:
  Input: nums1 = [1,3], nums2 = [2]
  Output: 2.00000
  Explanation: merged array = [1,2,3] and median is 2.
Example 2:
  Input: nums1 = [1,2], nums2 = [3,4]
  Output: 2.50000
  Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3
  Input: nums1 = [0,0], nums2 = [0,0]
  Output: 0.00000
Example 4:
  Input: nums1 = [], nums2 = [1]
  Output: 1.00000
Example 5:
  Input: nums1 = [2], nums2 = []
  Output: 2.00000
Constraints:
    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106
*/
class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        while (i < m && j < n)
            list.add(nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++]);
        while(i < m) 
            list.add(nums1[i++]);
        while(j < n) 
            list.add(nums2[j++]);
        return list.size() % 2 == 1 ? list.get(list.size() / 2) : 0.5 * (list.get(list.size() / 2 - 1) + list.get(list.size() / 2));
    }
}
