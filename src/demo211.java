public class demo211 {
    //添加与搜索单词 - 数据结构设计
    //字典树
    class WordDictionary {
        Trie root;
        public WordDictionary() {
            root=new Trie();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }
        private boolean dfs(String word, int index, Trie node) {
            if (index == word.length()) {
                return node.isEnd();
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)) {
                int childIndex = ch - 'a';
                Trie child = node.getChildren()[childIndex];
                if (child != null && dfs(word, index + 1, child)) {//不为null，就是存在
                    return true;
                }
            } else {
                for (int i = 0; i < 26; i++) {//如果是.需要遍历所有可能的child
                    Trie child = node.getChildren()[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //小写字母字典树
    class Trie{
        Trie[] children;
        boolean isEnd;
        public Trie(){
            children=new Trie[26];//26个小写字母
            isEnd=false;
        }
        public void insert(String word){
            Trie t = this;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int index=c-'a';
                if(t.children[index]==null){
                    t.children[index]=new Trie();
                }
                t=t.children[index];
            }
            t.isEnd=true;
        }
        public Trie[] getChildren(){
            return children;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
    public static void main(String[] args) {

    }
}