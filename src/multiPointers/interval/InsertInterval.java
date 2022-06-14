package multiPointers.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int len = intervals.length;
        int l = newInterval[0];
        int r = newInterval[1];
        int index = 0;
        while (index < len && intervals[index][1] < l) {
            result.add(intervals[index++]);
        }
        while (index < len && r >= intervals[index][0]) {
            l = Math.min(l, intervals[index][0]);
            r = Math.max(r, intervals[index][1]);
            index++;
        }
        result.add(new int[]{l, r});
        while (index < len) {
            result.add(intervals[index++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
