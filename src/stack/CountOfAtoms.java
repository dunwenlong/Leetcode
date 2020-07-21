package stack;

import java.util.*;

/**
 * @author Dun Wenlong
 * @time 2020/6/26 14:42
 * 题目：原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 */
public class CountOfAtoms {
    public static String countOfAtoms(String formula) {
        //字符串的每一位
        int i = 0;
        //构成原子
        int j = 0;
        char[] c = formula.toCharArray();
        int len = c.length;
        Stack<Character> bracketStack = new Stack<>();
        Stack<String> atomStack = new Stack<>();
        int[] bracketNums = new int[len];
        int[] atomNum = new int[len];
        while (i < len) {
            String atom = "";
            if (Character.isUpperCase(c[i])) {
                atom += c[i];
                i++;
            }
            //如果大写字母后面还有小写字母
            while (i < len && Character.isLowerCase(c[i])) {
                atom += c[i];
                i++;
            }
            String cnt = "";
            //如果后面有数，可能多位
            if (i < len && Character.isDigit(c[i])) {
                while (i < len && Character.isDigit(c[i])) {
                    cnt += c[i];
                    i++;
                }
                atomStack.push(atom);
                atomNum[j] = Integer.valueOf(cnt);
                bracketNums[j] = bracketStack.size();
                j++;
            } else {
                if (atom.length() != 0 && cnt.length() == 0) {
                    atomStack.push(atom);
                    atomNum[j] = 1;
                    bracketNums[j] = bracketStack.size();
                    j++;
                }
                if (i < len && c[i] == '(') {
                    bracketStack.push('(');
                    i++;
                } else if (i < len && c[i] == ')') {
                    i++;
                    cnt = "";
                    int cntNum = 1;
                    //遍历括号后面的数
                    if (i < len && Character.isDigit(c[i])) {
                        while (i < len && Character.isDigit(c[i])) {
                            cnt += c[i];
                            i++;
                        }
                        cntNum = Integer.valueOf(cnt);
                    }
                    for (int tempJ = j-1; tempJ >= 0; tempJ--) {
                        if (bracketNums[tempJ] == bracketStack.size()) {
                            atomNum[tempJ] = atomNum[tempJ] * cntNum;
                            bracketNums[tempJ] -= 1;
                        } else {
                            break;
                        }
                    }
                    bracketStack.pop();
                }
            }
        }
        TreeMap<String, Integer> res = new TreeMap<>();
        for(int tempi = 0; tempi<j; tempi++){
            if(res.isEmpty()){
                res.put(atomStack.get(tempi), atomNum[tempi]);
            } else{
                res.put(atomStack.get(tempi), res.getOrDefault(atomStack.get(tempi), 0)+atomNum[tempi]);
            }
        }
        StringBuilder stbRes = new StringBuilder();
        for(Map.Entry<String, Integer> entry:res.entrySet()){
            stbRes.append(entry.getKey());
            if(entry.getValue()!=1){
                stbRes.append(entry.getValue());
            }
        }
        return stbRes.toString();
    }
    public static void main(String[] args){
        System.out.println(CountOfAtoms.countOfAtoms("K4(ON(SO3)2)2"));
    }
}
