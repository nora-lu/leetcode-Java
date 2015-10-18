public class Solution {
    class Pair {
        int a, ai;
        int b, bi;
        public Pair(int a, int ai, int b, int bi) {
            this.a = a;
            this.b = b;
            this.ai = ai;
            this.bi = bi;
        }
        public boolean same(Pair p) {
            return p != null && p.a == a && p.b == b;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) { return res; }
        Arrays.sort(nums);
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        
        // put all pairs into map
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair pair = new Pair(nums[i], i, nums[j], j);
                int sum = nums[i] + nums[j];
                List<Pair> list = map.get(sum);
                if (list == null) {
                    list = new ArrayList<Pair>();
                    map.put(sum, list);
                }
                list.add(pair);
            }
        }
        
        // use 2 sum to find two pairs sum to target
        Integer first = map.firstKey();
        Integer last = map.lastKey();
        while (first != null && last != null && first <= last) {
            if (first + last > target) { last = map.lowerKey(last); }
            else if (first + last < target) { first = map.higherKey(first); }
            else if(first == last){
                List<Pair> list = map.get(first);
                for(int i = 0; i < list.size(); i++){
                    Pair a = list.get(i);
                    if(a.a == a.b){
                        for(int j = i + 1; j < list.size(); j++){
                            Pair b = list.get(j);
                            if(b.a == b.b){
                                if(a.bi < b.ai){
                                    res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                                    break;
                                }
                            }
                            else{ break; }
                        }
                        break;
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
            else{
                Pair lastA = null;
                for(Pair a : map.get(first)){
                    if(a.same(lastA)){
                        continue;
                    }
                    lastA = a;
                    Pair lastB = null;
                    for(Pair b: map.get(last)){
                        if(a.bi < b.ai){
                            if(b.same(lastB)){
                                continue;
                            }
                            lastB = b;
                            res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                        }
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
        }
        return res;
    }
}
