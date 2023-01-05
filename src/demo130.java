public class demo130 {
    //被围绕的区域
    public static void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        if(m<=2||n<=2){
            return;
        }
        for(int i=1;i<m-1;i++){
            if(board[i][0]=='O'){
                f(board,i,1);
            }
            if(board[i][n-1]=='O'){
                f(board,i,n-2);
            }
        }
        for(int i=1;i<n-1;i++){
            if(board[0][i]=='O'){
                f(board,1,i);
            }
            if(board[m-1][i]=='O'){
                f(board,m-2,i);
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void f(char[][] board,int i,int j){
        int m=board.length,n=board[0].length;
        if(i>0&&i<m-1&&j>0&&j<n-1&&board[i][j]=='O'){
            board[i][j]='#';
            f(board,i+1,j);
            f(board,i-1,j);
            f(board,i,j+1);
            f(board,i,j-1);
        }
    }
    public static void main(String[] args) {
        solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }

}