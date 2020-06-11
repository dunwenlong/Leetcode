import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Dun Wenlong
 * @date 2020/6/11
 */
public class MergInteveral {
    class IntervalsComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[][] merg(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new IntervalsComparator());

        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] peek = res.get(res.size() - 1);
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
                continue;
            } else {
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
