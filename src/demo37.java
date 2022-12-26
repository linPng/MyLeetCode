import javax.lang.model.SourceVersion;
import java.util.HashSet;
import java.util.Set;

public class demo37 {

    //37题
    //解数独
    public static void solveSudoku(char[][] board) {
        //set[]初始化
        Set[] h=new Set[9];
        Set[] s=new Set[9];
        Set[] f=new Set[9];
        Set<Integer> a=new HashSet<>();
        for(int i=0;i<9;i++){
            h[i]=new HashSet<>();
            s[i]=new HashSet<>();
            f[i]=new HashSet<>();
            a.add(i);
        }
        while(true){
            boolean flag=true;
            boolean noupdate=true;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    char e=board[i][j];
                    int n=e-'0';
                    if(e=='.'){
                        Set<Integer> b=new HashSet<>(a);
                        b.removeAll(h[i]);
                        b.removeAll(s[j]);
                        b.removeAll(f[(i/3)*3+j/3]);
                        System.out.println("b.size() = " + b.size());
                        if (b.size()==1){
                            int t= b.iterator().next();
                            board[i][j]= Character.valueOf(String.valueOf(t).charAt(0));
                            h[i].add(t);
                            s[j].add(t);
                            f[(i/3)*3+j/3].add(t);
                            noupdate=false;
                        }else if(b.size()>1){
                            flag=false;
                        }
                        System.out.println("e = " + e);
                    }else{
                        noupdate=h[i].add(n);
                        s[j].add(n);
                        f[(i/3)*3+j/3].add(n);
                    }
                }
            }
            if(flag)return;
            if(noupdate)break;
        }

        fillNum(board,h,s,f);

        System.out.println("1111 = " + 1111);

    }

    public static boolean fillNum(char[][] board,Set[] h,Set[] s,Set[] f) {
        boolean isend =true;
        Set<Integer> a=new HashSet<>();
        for(int i=0;i<9;i++){
            a.add(i);
            if(h[i].size()!=9||s[i].size()!=9||f[i].size()!=9){
                isend = false;
            }
        }
        if(isend){
            return true;
        }
        for(int x = 0; x < 9; x++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char e = board[i][j];
                    int n = e - '0';
                    if (e == '.') {
                        Set<Integer> b = new HashSet<>(a);
                        b.removeAll(h[i]);
                        b.removeAll(s[j]);
                        b.removeAll(f[(i / 3) * 3 + j / 3]);
                        if (b.size() <= 0) {
                            return false;
                        }
                        for(int y = 0; y < x; y++) {
                            b.iterator().next();
                        }
                        int t = b.iterator().next();
                        System.out.println("t = " + t);
                        board[i][j] = Character.valueOf(String.valueOf(t).charAt(0));
                        h[i].add(t);
                        s[j].add(t);
                        f[(i / 3) * 3 + j / 3].add(t);
                        boolean callback = fillNum(board, h, s, f);
                        if (!callback) {
                            System.out.println("remove t = " + t);
                            System.out.println("||||| x = " + x+";i = " + i+";j = " + j);
                            board[i][j] = '.';
                            h[i].remove(t);
                            s[j].remove(t);
                            f[(i / 3) * 3 + j / 3].remove(t);
                        }else{
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board= {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}
;
        solveSudoku(board);
    }
}
