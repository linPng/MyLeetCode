public class demo135 {
    //分发糖果
    public static int candy(int[] ratings) {
        int ret=0,t=0;
        int[] l=new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                l[i]=l[i-1]+1;
            }else{
                l[i]=1;
            }
        }
        int r=1;
        for(int i=ratings.length-1;i>=0;i--){
            if(i<ratings.length-1&&ratings[i]>ratings[i+1]){
                r=r+1;
            }else{
                r=1;
            }
            ret+=Math.max(r,l[i]);
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + candy(new int[]{1,2,2}));
    }

}