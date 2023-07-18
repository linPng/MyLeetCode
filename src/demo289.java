import java.util.Arrays;

public class demo289 {
    //寻找重复数
    //生命游戏
    int[][] b;
    public void gameOfLife(int[][] board) {
        b = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            b[i] = Arrays.copyOf(board[i], board[i].length);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int r=0;
                int islive=b[i][j];
                int num=getNum(i,j);
                if(islive==1){
                    if(num==2||num==3){
                        r=1;
                    }else{
                        r=0;
                    }
                }else{
                    if(num==3){
                        r=1;
                    }else{
                        r=0;
                    }
                }
                board[i][j]=r;
            }
        }
    }
    public int getNum(int x,int y) {
        int count=0;
        try {count+=b[x-1][y-1];} catch (Exception e) {}
        try {count+=b[x-1][y];} catch (Exception e) {}
        try {count+=b[x-1][y+1];} catch (Exception e) {}
        try {count+=b[x][y-1];} catch (Exception e) {}
        try {count+=b[x][y+1];} catch (Exception e) {}
        try {count+=b[x+1][y-1];} catch (Exception e) {}
        try {count+=b[x+1][y];} catch (Exception e) {}
        try {count+=b[x+1][y+1];} catch (Exception e) {}
        return count;
    }
    public static void main(String[] args) {

    }
}
