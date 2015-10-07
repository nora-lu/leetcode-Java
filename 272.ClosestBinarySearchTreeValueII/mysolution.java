public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                if (Math.abs(x - target) < Math.abs(y - target)) { return -1; }
                else if (Math.abs(x - target) > Math.abs(y - target)) { return 1; }
                else { return 0; }
            }
        });
        addToPQ(root, pq);
        
        while (k-- > 0) { res.add(pq.poll()); }
        return res;
    }
    
    private void addToPQ(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) { return; }
        addToPQ(root.left, pq);
        pq.add(root.val);
        addToPQ(root.right, pq);
    }
}
