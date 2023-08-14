package contest.weeklycontest88;

public class B {
    //849. 到最近的人的最大距离
    public int maxDistToClosest(int[] seats) {
        int ret=0;
        int n=seats.length;
        int[] l=new int[n];
        int[] r=new int[n];
        l[0]=seats[0]==1?0:2 * 100000;
        for(int i=1;i<n;i++){
            if(seats[i]==1){
                l[i]=0;
            }else{
                l[i]=l[i-1]+1;
            }
        }
        r[n-1]=seats[n-1]==1?0:2 * 100000;
        for(int i=n-2;i>=0;i--){
            if(seats[i]==1){
                r[i]=0;
            }else{
                r[i]=r[i+1]+1;
            }
        }
        for(int i=0;i<n;i++){
            int t=Math.min(r[i],l[i]);
            ret=Math.max(ret,t);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
