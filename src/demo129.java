public class demo129 {
    //求根节点到叶节点数字之和
    static int ret=0;
    public static int sumNumbers(TreeNode root) {
        if(root.left==null&&root.right==null){
            return root.val;
        }
        f(root,0);
        return ret;
    }
    public static void f(TreeNode root,int sum) {
        if(root.left==null&&root.right==null){
            ret+=sum*10+root.val;
        }
        if(root.left!=null){
            f(root.left,sum*10+root.val);
        }
        if(root.right!=null){
            f(root.right,sum*10+root.val);
        }
    }

    //正常的递归
    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
    public static void main(String[] args) {

    }

}