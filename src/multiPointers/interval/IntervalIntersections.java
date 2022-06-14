package multiPointers.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int first = 0;
        int second = 0;
        while (first < firstList.length && second < secondList.length) {
            int l = Math.max(firstList[first][0], secondList[second][0]);
            int r = Math.min(firstList[first][1], secondList[second][1]);
            // 这一个判断简直妙呆了，把那么多重叠情况全总结了。
            if (l <= r) {
                result.add(new int[]{l, r});
            }
            if (firstList[first][1] < secondList[second][1]) {
                first++;
            } else {
                second++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
