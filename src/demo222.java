public class demo222 {
    //完全二叉树的节点个数
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return countNodes(root.left)+countNodes(root.right)+1;
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