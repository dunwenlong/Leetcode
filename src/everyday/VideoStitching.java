package everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dun Wenlong
 * @time 24/10/2020 下午 2:20
 */
public class VideoStitching {
//    public int videoStitching(int[][] clips, int T) {
//        if(clips.length<1){
//            return -1;
//        }
//        Arrays.sort(clips, new MyComparator());
//        if(clips[0][0]!=0){
//            return -1;
//        }
//        int n = clips.length;
//        int res = 1;
//        int i = 0;
//        while(clips[i][0] == 0){
//            i++;
//        }
//        int end = clips[i-1][1];
//        while(i<n){
//            if(end>=T){
//                break;
//            }
//            int temp = Integer.MIN_VALUE;
//            while(i<n && clips[i][0]<=end){
//                temp = Math.max(temp, clips[i][1]);
//                i++;
//            }
//            end = temp;
//            res++;
//            i++;
//        }
//        if(end<T){
//            return -1;
//        } else{
//            return res;
//        }
//    }
//    class MyComparator implements Comparator<int[]>{
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            if(o1[0]==o2[0]){
//                return o1[1]-o2[1];
//            } else{
//                return o1[0]-o2[0];
//            }
//        }
//    }

    public int videoStitching(int[][] clips, int T) {
        if(clips.length<1){
            return -1;
        }
        int n = clips.length;
        int[] maxn = new int[T];
        for(int[] clip: clips){
            maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
        }
        int res = 1;
        int i = 1;
        int end = maxn[0];
        while(i<T){
            if(end>=T){
                break;
            }
            int temp = Integer.MIN_VALUE;
            while(i<=end){
                temp = Math.max(temp, maxn[i]);
                i++;
            }
            end = temp;
            res++;
            i++;
        }
        if(end<T){
            return -1;
        } else{
            return res;
        }
    }
    public static void main(String[] args){
        VideoStitching videoStitching = new VideoStitching();
        int[][] clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},
                {1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        System.out.println(videoStitching.videoStitching(clips, 9));
    }
}
