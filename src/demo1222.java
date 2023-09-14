import java.util.*;

public class demo1222 {
    //1222. 可以攻击国王的皇后
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ret = new LinkedList<>();
        Map<Integer,int[]> map = new HashMap();
        for(int[] i:queens){
            int k=-1;
            if (i[0] == king[0]&&i[1]<king[1]) {
                k=0;
            } else if (i[0] == king[0]&&i[1]>king[1]) {
                k=1;
            } else if (i[1] == king[1]&&i[0]<king[0]) {
                k=2;
            } else if (i[1] == king[1]&&i[0]>king[0]) {
                k=3;
            } else if (i[0] - king[0] == i[1] - king[1]&&i[0]>king[0]) {
                k=4;
            } else if (i[0] - king[0] == i[1] - king[1]&&i[0]<king[0]) {
                k=5;
            } else if (i[0] + i[1] == king[0] + king[1]&&i[0]>king[0]) {
                k=6;
            } else if (i[0] + i[1] == king[0] + king[1]&&i[0]<king[0]) {
                k=7;
            }else{
                continue;
            }
            int[] t=map.getOrDefault(k,i);
            if(Math.abs(i[0]-king[0])+Math.abs(i[1]-king[1])<=Math.abs(t[0]-king[0])+Math.abs(t[1]-king[1])){
                map.put(k,i);
            }

        }
        for(int j:map.keySet()){
            ret.add(new LinkedList<>(Arrays.asList(map.get(j)[0], map.get(j)[1])));
        }
        return ret;
    }
    // 需要考虑阻挡的情况
    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        List<List<Integer>> ret = new LinkedList<>();
        for(int[] i:queens){
            if(i[0]==king[0]||i[1]==king[1]||i[0]-king[0]==i[1]-king[1]||i[0]+i[1]==king[0]+king[1]){
                ret.add(new LinkedList<>(Arrays.asList(i[0], i[1])));
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
