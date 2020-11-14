package everyday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Dun Wenlong
 * @time 2020/11/5 21:22
 */
public class LadderLength1105 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> path = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        path.offer(beginWord);
        int count = 0;
        while(!path.isEmpty()){
            int size = path.size();
            count++;
            for(int i = 0; i < size; i++){
                String start = path.poll();
                for(String s:wordList){
                    if(visited.contains(s)){
                        continue;
                    }
                    // 用于调试
                    // System.out.println(count + ": " + start + "->" + s);
                    // 可以转换，并且能转换成 endWord，则返回 count
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    visited.add(s);
                    path.offer(s);
                }
            }
        }
        return 0;
    }
    public boolean canConvert(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
