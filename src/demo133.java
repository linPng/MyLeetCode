import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo133 {
    //克隆图  无向连通图
    static Map<Integer,List<Integer>> map = new HashMap<>();
    public static nNode cloneGraph(nNode node) {
        add(node);
        nNode[] ns=new nNode[map.size()+1];
        for(int i=1;i<=map.size();i++){
            ns[i]=new nNode(i);
        }
        for(int i=1;i<=map.size();i++){
            List<nNode> l = new ArrayList<>();
            for(int e:map.get(i)){
                l.add(ns[e]);
            }
            ns[i].neighbors=l;
        }
        return ns[1];
    }
    public static void add(nNode n){
        if(map.containsKey(n.val)){
            return;
        }else{
            List<Integer> l =new ArrayList<>();
            map.put(n.val,null);
            for(nNode e:n.neighbors){
                add(e);
                l.add(e.val);
            }
            map.put(n.val,l);
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " );
    }

    static class nNode {
        public int val;
        public List<nNode> neighbors;
        public nNode() {
            val = 0;
            neighbors = new ArrayList<nNode>();
        }
        public nNode(int _val) {
            val = _val;
            neighbors = new ArrayList<nNode>();
        }
        public nNode(int _val, ArrayList<nNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}