import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo124 {
    //二叉树中的最大路径和
    public static int maxPathSum(TreeNode root) {
        List<List<TreeNode>> tree = getListTree(root);
        int ret=Integer.MIN_VALUE;
        for(int i=tree.size()-1;i>=0;i--){
            for(TreeNode t:tree.get(i)){
                int l=0,r=0;
                if(t.left!=null&&t.left.val>0)l=t.left.val;
                if(t.right!=null&&t.right.val>0)r=t.right.val;
                if(t.val+l+r>ret){
                    ret=t.val+l+r;
                }
                t.val=t.val+Math.max(l,r);
            }
        }
        return ret;
    }
    //层序遍历 返回树的每一层
    public static List<List<TreeNode>> getListTree(TreeNode root) {
        List<List<TreeNode>> ret = new ArrayList<List<TreeNode>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//先进先出
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<TreeNode>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
    //递归
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);
        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
    public static void main(String[] args) {
        //System.out.println(" = " + maxPathSum());
    }

}