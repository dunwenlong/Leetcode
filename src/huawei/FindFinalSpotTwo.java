package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dun Wenlong
 * @time 2020/8/19 9:43
 */
public class FindFinalSpotTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str=reader.readLine())!=null){
            String[] cur=str.split(";");
            int x=0;
            int y=0;
            for(int i=0;i<cur.length;i++){
                char[] arr=cur[i].toCharArray();
                int change=0;
                for(int j=1;j<arr.length;j++){
                    if(arr[j]>='0'&&arr[j]<='9'){
                        change=change*10+(arr[j]-'0');
                    }else{
                        break;
                    }
                }
                switch(arr[0]){
                    case 'A':
                        x-=change;
                        break;
                    case 'D':
                        x+=change;
                        break;
                    case 'W':
                        y+=change;
                        break;
                    case 'S':
                        y-=change;
                        break;
                    default:
                        break;
                }
            }
            System.out.println(x+","+y);
        }
    }
}
