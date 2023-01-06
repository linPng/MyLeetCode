public class demo134 {
    //加油站
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int [] c=new int[gas.length];
        int sum=0;
        for(int i=0;i<gas.length;i++){
            c[i]=gas[i]-cost[i];
            sum+=c[i];
        }
        if(sum<0){
            return -1;
        }
        int max=0,ret=0,t=0,n=gas.length;
        sum=0;
        for(int i=0;i<=n*2;i++){
            while(c[i%n]<0){
                i++;
                sum=0;
            }
            sum=c[i%n];
            t=i;
            while(sum>=0){
                i++;
                sum+=c[i%n];
                if(t==i%n){
                    return t;
                }
            }

        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
        /*[]
[]*/
        System.out.println(" = " + canCompleteCircuit(new int[]{5,8,2,8},new int[]{6,5,6,6}));
    }

}