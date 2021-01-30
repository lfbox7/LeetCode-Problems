class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], 2);
            } else {
                map.put(nums[i], 1);
            }
        }
        return getKey(map, 1);
    } 
    
    public <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
