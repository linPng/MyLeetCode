import java.util.PriorityQueue;

public class demo230 {
    //二叉搜索树中第K小的元素
    PriorityQueue<Integer> min = new PriorityQueue<Integer>((a, b) -> a - b);
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        while(--k>0){
            min.poll();
        }
        return min.poll();
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        min.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public static void main(String[] args) {

    }
}