public class TwoSum {
    private Map<Integer, Integer> map = new HashMap<>();  // key: number, value: times being added
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.get(number) == null ? 1 : map.get(number) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int key : map.keySet()) {
	        int pair = value - key;
	        if ((key == pair && map.get(key) > 1) || (key != pair && map.containsKey(pair))) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
