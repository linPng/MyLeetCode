import java.util.HashSet;
import java.util.Set;

public class demo79 {
    //单词搜索
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    Set<String> set=new HashSet<>();
                    set.add(i+"#"+j);
                    if(f(board,word,i,j,set)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean f(char[][] board, String word,int i,int j,Set<String> set){
        if(set.size()==word.length()){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        int c=set.size();
        for(int k=0;k<4;k++){
            int a=k/2==0?i:k%2==0?i+1:i-1;
            int b=k/2==1?j:k%2==0?j+1:j-1;
            if(a>=0&&a<m&&b>=0&&b<n&&board[a][b]==word.charAt(c)&&!set.contains(a+"#"+b)){
                set.add(a+"#"+b);
                if(f(board,word,a,b,set)){
                    return true;
                }
                set.remove(a+"#"+b);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(" = " + exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }

}