public class demo979 {
    //在二叉树中分配硬币
    int ret;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ret;
    }
    public int dfs(TreeNode root){
        int l=0;
        int r=0;
        int m=0;
        if(root==null){
            return 0;
        }
        if(root.left!=null){
            l=dfs(root.left);
        }
        if(root.right!=null){
            r=dfs(root.right);
        }
        m=root.val-1;
        ret+=Math.abs(r)+Math.abs(l);
        return r+l+m;
    }
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
 }
}