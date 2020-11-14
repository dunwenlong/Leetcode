package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dun Wenlong
 * @time 2020/8/31 14:10
 */
public class VisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if(n<1){
            return false;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        int num = 0;
        while(!path.isEmpty()){
            int x = path.removeLast();
            num++;
            for(int i: rooms.get(x)){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    path.addLast(i);
                }
            }
        }
        return num==n;
    }
}
