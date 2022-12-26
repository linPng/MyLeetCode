import java.util.HashSet;
import java.util.Set;

public class demo36 {

    //36题
    //判断数独是否成立
    public static boolean isValidSudoku(char[][] board) {
        //set[]初始化
        Set[] h=new Set[9];
        Set[] s=new Set[9];
        Set[] f=new Set[9];
        for(int i=0;i<9;i++){
            h[i]=new HashSet<>();
            s[i]=new HashSet<>();
            f[i]=new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char e=board[i][j];
                if(e=='.'){
                    continue;
                }
                //set.add 如果已经存在则返回false;
                if(!h[i].add(e)){
                    return false;
                }
                if(!s[j].add(e)){
                    return false;
                }
                int t=(i/3)*3+(j/3);
                if(!f[t].add(e)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board= {{'8','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("isValidSudoku(board) = " + isValidSudoku(board));
    }
}
