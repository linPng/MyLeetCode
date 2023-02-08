import java.util.*;

public class demo1233 {
    //删除子文件夹
    //哈希字典树
    public List<String> removeSubfolders3(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {//构建字典树
            List<String> path = split(folder[i]);
            Trie cur = root;
            for (String name : path) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<String>();
        dfs(folder, ans, root);
        return ans;
    }

    public List<String> split(String s) {//按序返回路径
        List<String> ret = new ArrayList<String>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref != -1) {//只取第一个结束节点
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs(folder, ans, child);
        }
    }
    class Trie {
        int ref;
        Map<String, Trie> children;

        public Trie() {
            ref = -1;
            children = new HashMap<String, Trie>();
        }
    }
    //排序
    public List<String> removeSubfolders2(String[] folder) {
        List<String> ret = new ArrayList<>();
        Arrays.sort(folder);
        String p=folder[0];
        ret.add(p);
        for(int i=1;i<folder.length;i++){
            String s=folder[i];
            if(s.equals(p)){
                continue;
            }else if(s.startsWith(p+"/")){
                continue;
            }else{
                p=s;
                ret.add(p);
            }
        }
        return ret;
    }
    //哈希双循环 暴力法
    public List<String> removeSubfolders(String[] folder) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s: folder){
            set.add(s);
        }
        for(String s: folder){
            boolean isadd = true;
            String key="";
            for(int i=1;i<s.split("/").length-1;i++){
                key+="/"+s.split("/")[i];
                if(set.contains(key)){
                    isadd=false;
                    break;
                }
            }
            if(isadd){
                ret.add(s);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
    }
}
