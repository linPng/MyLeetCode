package planning.BasicDataStructures.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Array09_56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> ret=new ArrayList<>();
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (ret.size() == 0 || ret.get(ret.size() - 1)[1] < L) {
                ret.add(new int[]{L, R});
            } else {
                ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1], R);
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

}
