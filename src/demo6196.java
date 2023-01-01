public class demo6196 {
    //将字符串分割成值不超过 K 的子字符串
    public static int minimumPartition(String s, int k) {
        int n = s.length();
        int r=0;
        String key=String.valueOf(k);
        if((s.charAt(n-1) - '0')>k){
            return -1;
        }
        for (int i = 0; i <n; ) {
            int j=i+key.length();
            if(j>n)j=n;
            String key2=s.substring(i,j);
            if(key.length()==key2.length()&&key.compareTo(key2)<0){
                j--;
                if(j==i){
                    return -1;
                }
            }
            i=j;
            r++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(" = " + minimumPartition("128288",16));
        System.out.println(" = " + minimumPartition("1829727651",10));
        System.out.println(" = " + minimumPartition("165462",60));
        System.out.println(" = " + minimumPartition("238182",5));

    }

}