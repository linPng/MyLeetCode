public class demo2596 {
    //2596. 检查骑士巡视方案
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int k=n*n;
        int x=0,y=0;
        /*必须是左上角开始
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(grid[i][j]==0){
                   x=i;y=j;
               }
            }
        }*/
        int c=0;
        while(c<k){
            System.out.println("c = " + c);
            System.out.println("[x][y] = " + x+","+y);
            if(grid[x][y]!=c){
                return false;
            }
            if(x+2>=0&&x+2<n&&y+1>=0&&y+1<n&&grid[x+2][y+1]==c+1){
                x+=2;y+=1;
            }else if(x+2>=0&&x+2<n&&y-1>=0&&y-1<n&&grid[x+2][y-1]==c+1){
                x+=2;y-=1;
            }else if(x-2>=0&&x-2<n&&y+1>=0&&y+1<n&&grid[x-2][y+1]==c+1){
                x-=2;y+=1;
            }else if(x-2>=0&&x-2<n&&y-1>=0&&y-1<n&&grid[x-2][y-1]==c+1){
                x-=2;y-=1;
            }else if(x+1>=0&&x+1<n&&y+2>=0&&y+2<n&&grid[x+1][y+2]==c+1){
                x+=1;y+=2;
            }else if(x+1>=0&&x+1<n&&y-2>=0&&y-2<n&&grid[x+1][y-2]==c+1){
                x+=1;y-=2;
            }else if(x-1>=0&&x-1<n&&y+2>=0&&y+2<n&&grid[x-1][y+2]==c+1){
                x-=1;y+=2;
            }else if(x-1>=0&&x-1<n&&y-2>=0&&y-2<n&&grid[x-1][y-2]==c+1){
                x-=1;y-=2;
            }
            c++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] array = {
                {0, 11, 16, 5, 20},
                {17, 4, 19, 10, 15},
                {12, 1, 8, 21, 6},
                {3, 18, 23, 14, 9},
                {24, 13, 2, 7, 22}
        };
        int[][] array2 = {
                {24, 11, 22, 17, 4},
                {21, 16, 5, 12, 9},
                {6, 23, 10, 3, 18},
                {15, 20, 1, 8, 13},
                {0, 7, 14, 19, 2}
        };
        demo2596 d = new demo2596();
        System.out.println("d.checkValidGrid(array) = " + d.checkValidGrid(array2));
    }
}
