import java.util.ArrayDeque;
import java.util.Deque;

public class demo117 {
    //填充每个节点的下一个右侧节点指针 II 层序遍历
    public static Node connect(Node root) {
        Node ret = root;
        if (root == null) {
            return ret;
        }
        Deque<Node> queue = new ArrayDeque<Node>();//先进先出
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            Node nodeP = null;
            for (int i = 1; i <= currentLevelSize; ++i) {
                Node node = queue.pollFirst();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if(nodeP!=null){
                    nodeP.next=node;
                }
                nodeP=node;
            }
        }

        return ret;
    }
    public static void main(String[] args) {

    }

}
