public class demo111 {
    //二叉树的最小深度  排除非叶子节点
    public static boolean isroot=true;
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);
            if(leftHeight==0){
                return rightHeight+1;
            }
            if(rightHeight==0){
                return leftHeight+1;
            }
            if(rightHeight==0&&leftHeight==0){
                return 0;
            }
            return Math.min(leftHeight, rightHeight) + 1;
        }
    }
    public static void main(String[] args) {

    }

}