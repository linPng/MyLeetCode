public class demo98 {
    //验证二叉搜索树
    public static boolean isValidBST(TreeNode root) {
        return f(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static boolean f(TreeNode root,int l,int r) {
        if(root==null){
            return true;
        }
        if(root.left!=null&&(root.left.val>=root.val||root.left.val<l)){
            return false;
        }
        if(root.right!=null&&(root.right.val<=root.val||root.right.val>r)){
            return false;
        }
        return f(root.left,l,root.val-1)&&f(root.right,root.val+1,r);
    }
    public static void main(String[] args) {
        System.out.println();
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