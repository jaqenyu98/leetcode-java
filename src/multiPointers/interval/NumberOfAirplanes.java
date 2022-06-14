package multiPointers.interval;

import java.util.ArrayList;
import java.util.List;

public class NumberOfAirplanes {
    public int countOfAirplanes(List<Interval> airplanes){
        List<Node> list = new ArrayList<>();
        for (Interval flight: airplanes) {
            list.add(new Node(flight.start, 1));
            list.add(new Node(flight.end, -1));
        }
        // 如果一个飞机的起飞时间=另一架飞机的降落时间，根据题意，降落在前
        list.sort((o1, o2) -> o1.time == o2.time ? o1.flag - o2.flag : o1.time - o2.time);
        int count = 0;
        int max = 0;
        for (Node node : list) {
            if (node.flag == 1) {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    private static class Node {
        int time;
        // flag: 1 means start time; -1 means end time
        int flag;
        Node(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    private static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
