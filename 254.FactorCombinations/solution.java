/* Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
] */

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        getFactors(n, ret, new ArrayList<Integer>(), 2);
        return ret;
    }
    
    private void getFactors(int n, List<List<Integer>> ret, List<Integer> cur, int start) {
        if (n == 1) {
            if (cur.size() > 1) {  // prevent case of n * 1
                ret.add(new ArrayList<Integer>(cur));
                return;
            }
        }
        for (int f = start; f <= n; f++) {  // IMPORTANT: f <= n here
            if (n % f == 0) {
                cur.add(f);
                getFactors(n / f, ret, cur, f);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
