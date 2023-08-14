package contest.weeklycontest85;

import java.util.HashSet;
import java.util.Set;

public class D {
    //839. 相似字符串组
    //是求连通分量
    int[] f;//f[i]=父节点
    //没理解题意
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        int ret=0;
        f=new int[n];
        for(int i=0;i<n;i++){
            f[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=find(i);
                int b=find(j);
                if(a==b){
                    continue;
                }
                if(isSame(strs[i],strs[j])){
                    f[b]=a;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(f[i]==i){
                ret++;
            }
        }
        System.out.println("f = " + f);
        return ret;
    }
    public int find(int i){
//        return f[i]==i?i:find(f[i]);
        return f[i] == i ? i : (f[i] = find(f[i]));
    }
    public boolean isSame(String s1,String s2){
        int n=s1.length();
        if(s1.equals(s2)){
            return true;
        }
        Set set = new HashSet();
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1!=c2){
                set.add(c1);
                set.add(c2);
            }
        }
        if(set.size()==2){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        D d=new D();
        System.out.println("d.numSimilarGroups() = " + d.numSimilarGroups(
                new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}
        ));
    }
}
