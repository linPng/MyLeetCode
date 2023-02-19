import java.util.*;

public class demo212 {
    //单词搜索 II 困难
    //字典树+dfs
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//代表四个方向
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {//初始化字典树
            trie.insert(word);
        }
        Set<String> ans = new HashSet<String>();//去重
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, ans);//从根节点开始
            }
        }
        return new ArrayList<String>(ans);
    }

    public void dfs(char[][] board, Trie now, int i1, int j1, Set<String> ans) {
        char ch = board[i1][j1];
        if (!now.children.containsKey(ch)) {
            return;
        }
        now = now.children.get(ch);
        if (!"".equals(now.word)) {//遇到结束的单词
            ans.add(now.word);
        }
        board[i1][j1] = '#';//防止重复取
        for (int[] dir : dirs) {//遍历四个方向
            int i2 = i1 + dir[0], j2 = j1 + dir[1];
            if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                dfs(board, now, i2, j2, ans);
            }
        }
        board[i1][j1] = ch;
    }

    //通用字符串字典树
    class Trie {
        String word;//word存储在叶子节点
        Map<Character, Trie> children;
        boolean isWord;
        public Trie() {
            this.word = "";
            this.children = new HashMap<Character, Trie>();
        }
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
    }
    //哈希+dfs 暴力递归会超时，因为可能会有大量公共前缀的单词，所以要用字典树
    static Map<Character,Set<int[]>> map = new HashMap<>();
    public static List<String> findWords2(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Set<int[]> b = map.getOrDefault(board[i][j],new HashSet<>());
                b.add(new int[]{i,j});
                map.put(board[i][j],b);
            }
        }
        for(String s:words){
            for(int[] w:map.getOrDefault(s.charAt(0),new HashSet<>())){
                if(dfs(w[0],w[1],s,0,board,new HashSet<>())){
                    ret.add(s);
                    break;
                }
            }
        }
        return ret;
    }
    public static boolean dfs(int i,int j, String word, int index, char[][] board, Set<String> set){
        /*if(!(i>=0&&i<board.length&&j>=0&&j<board[0].length)){
            return false;
        }*/
        char c=board[i][j];
        if(index==word.length()-1){
            if(word.charAt(index)==c){
                return true;
            }
            return false;
        }
        /*if(c!=word.charAt(index)){
            return false;
        }*/
        String key=i+"#"+j;
        if(set.contains(key)){
            return false;
        }
        set.add(key);
        char nextchar=word.charAt(index+1);
        for(int[] n:map.getOrDefault(nextchar,new HashSet<>())){
            if((n[0]==i&&(n[1]==j+1||n[1]==j-1))||(n[1]==j&&(n[0]==i+1||n[0]==i-1))){
                if(dfs(n[0],n[1],word,index+1,board,set)){
                    return true;
                }
            }
        }
        //暴力回溯会超时
        /*if(dfs(i,j+1,word,index+1,board,set)){
            return true;
        }
        if(dfs(i,j-1,word,index+1,board,set)){
            return true;
        }
        if(dfs(i-1,j,word,index+1,board,set)){
            return true;
        }
        if(dfs(i+1,j,word,index+1,board,set)){
            return true;
        }*/
        set.remove(key);
        return false;
    }
    public static void main(String[] args) {
        /*System.out.println("findWords() = " + findWords(new char[][]{{'a','b','c'},{'a','e','d'},{'a','f','g'}}
        ,new String[]{"eaafgdcba"}));*/
        /*System.out.println("findWords() = " + findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}
        ,new String[]{"oath","pea","eat","rain"}));*/
    }
}