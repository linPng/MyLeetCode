import java.util.ArrayList;
import java.util.List;

public class demo94 {
    //二叉树的中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> r=inorderTraversal(root.left);
        r.add(root.val);
        r.addAll(inorderTraversal(root.right));
        return r;
    }
    public static void main(String[] args) {
        TreeNode t=new TreeNode();
        inorderTraversal(t);
    }
    public static class TreeNode {
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
