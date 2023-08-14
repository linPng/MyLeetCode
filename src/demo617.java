public class demo617 {
    //617. 合并二叉树 简单
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return null;
        }
        TreeNode r= new TreeNode(0);
        if(root2==null){
            r.val=r.val+root1.val;
            r.left=mergeTrees(root1.left,null);
            r.right=mergeTrees(root1.right,null);
        }else if(root1==null){
            r.val=r.val+root2.val;
            r.left=mergeTrees(root2.left,null);
            r.right=mergeTrees(root2.right,null);
        }else{
            r.val=root1.val+root2.val;
            r.left=mergeTrees(root1.left,root2.left);
            r.right=mergeTrees(root1.right,root2.right);
        }
        return r;
    }
    public static void main(String[] args) {

    }
}
