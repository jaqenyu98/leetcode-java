package multiPointers.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {
    /*------------------------------------252题-------------------------------------*/
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        }
        return true;
    }

    /*------------------------------------253题-------------------------------------*/
    public int minMeetingRooms(int[][] intervals) {
        List<Node> list = new ArrayList<>();
        for (int[] meeting : intervals) {
            list.add(new Node(meeting[0], 1));
            list.add(new Node(meeting[1], -1));
        }
        list.sort((o1, o2) -> o1.time != o2.time ? o1.time - o2.time : o1.flag - o2.flag);
        int count = 0;
        int max = 0;
        for (Node node : list) {
            if (node.flag == 1)
                count++;
            else
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
    private static class Node {
        int time;
        // 1: start; -1: end
        int flag;
        Node(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
