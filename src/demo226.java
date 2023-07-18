public class demo226 {
    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        return root;
    }
    public static void main(String[] args) {

    }
}