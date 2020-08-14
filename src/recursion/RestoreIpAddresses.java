package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dun Wenlong
 * @time 2020/8/9 19:58
 */
public class RestoreIpAddresses {
    public List<String> res = new ArrayList<String>();
    public final int CONST_NUM = 4;
    public int[] ipAddress = new int[CONST_NUM];
    public List<String> restoreIpAddresses(String s) {
        if(s==null ||s.length()<CONST_NUM){
            return res;
        }
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int id, int startIndex) {
        if(id==CONST_NUM){
            if(startIndex == s.length()){
                StringBuilder stb = new StringBuilder();
                for(int i=0; i<CONST_NUM; i++){
                    stb.append(ipAddress[i]);
                    if(i!=CONST_NUM-1){
                        stb.append('.');
                    }
                }
                res.add(stb.toString());
            } else{
                return;
            }
        }
        if(startIndex == s.length()){
            return;
        }
        if(s.charAt(startIndex)=='0'){
            ipAddress[id] = 0;
            dfs(s, id+1, startIndex+1);
        }
        int numIp = 0;
        for(int endIndex = startIndex; endIndex<s.length(); endIndex++){
            numIp = numIp*10 +(s.charAt(endIndex)-'0');
            if(numIp>0 && numIp<=255){
                ipAddress[id] = numIp;
                dfs(s, id+1, endIndex+1);
            } else{
                break;
            }
        }
    }

}
