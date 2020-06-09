import java.util.Arrays;
import java.util.Comparator;

public class MinConstructNumber {
    public String minNumber(int [] nums){
        //整数数组转换为字符串数组
        String[] strList = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strList[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strList, new mycomp());
        StringBuilder stb = new StringBuilder();
        for(int i=0; i<strList.length; i++){
            stb.append(strList[i]);
        }
        return stb.toString();
    }
    class mycomp implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s1.compareTo(s2);
        }
    }

//    // 将数组按照这个比较器排序就可以得到答案了
//    class comp implements Comparator<String>{
//        public int compare(String m, String n){
//            String s1 = m+n;
//            String s2 = n+m;
//            return s1.compareTo(s2);
//        }
//    }
}
