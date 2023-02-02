import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo199 {
    //二叉树的右视图
    //层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret=new ArrayList<>();
        List<List<Integer>> list = levelOrder(root);
        for(List<Integer> l:list){
            ret.add(l.get(l.size()-1));
        }
        return ret;
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//先进先出
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
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
    public static void main(String[] args) {

    }
}
