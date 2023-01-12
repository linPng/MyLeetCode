import java.util.HashMap;
import java.util.Map;

public class demo138 {
    //复制带随机指针的链表
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        if(!map.containsKey(head)){
            Node newNode=new Node(head.val);
            map.put(head,newNode);
            copyRandomList(head.random);
            copyRandomList(head.next);
        }
        return map.get(head);
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}