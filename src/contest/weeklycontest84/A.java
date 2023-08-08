package contest.weeklycontest84;

public class A {
    //832. 翻转图像
    //模拟
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] i:image){
            int l=0;
            int r=i.length-1;
            while(r>=l){
                i[l]=(i[l]+1)%2;//i[l]^= 1;
                if(r==l){
                    break;
                }
                i[r]=(i[r]+1)%2;
                int t=i[l];
                i[l]=i[r];
                i[r]=t;
                l++;r--;
            }
        }
        return image;
    }
    public static void main(String[] args) {

    }
}