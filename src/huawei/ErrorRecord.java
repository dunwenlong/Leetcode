package huawei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dun Wenlong
 * @time 2020/8/26 14:09
 */
public class ErrorRecord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> records = new LinkedHashMap<>();
        while(sc.hasNext()){
            String path = sc.next();
            int lines = sc.nextInt();
            String[] ss = path.split("\\\\");
            String fileName = ss[ss.length-1];
            if(fileName.length()>16){
                fileName = fileName.substring(ss.length-16);
            }
            String key = fileName+" "+lines;
            records.put(key, records.getOrDefault(key, 0)+1);
        }
        int count=0;
        for(String string:records.keySet()){
            count++;
            if(count>(records.keySet().size()-8)) {
                System.out.println(string+" "+records.get(string));
                //输出最后八个记录
            }
        }
    }
}
