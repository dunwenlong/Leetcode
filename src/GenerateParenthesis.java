import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//面试题 08.09. 括号
public class GenerateParenthesis {
    private static ArrayList<String> res;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        back(n, n, temp);
        return res;
    }
    //lNum和rNum分别表示可供放置的左右括号数
    public static void back(int lNum, int rNum, StringBuilder cur){
        if(lNum == 0 && rNum == 0){
            res.add(cur.toString());
        }
        if(lNum>rNum){
            return;
        }
        if(lNum>0){
            cur.append('(');
            back(lNum-1, rNum, cur);
            cur.deleteCharAt(cur.length()-1);
        }
        if(rNum>0){
            cur.append(')');
            back(lNum, rNum-1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    public static void main(String[] args){
        ArrayList<String> tempList = (ArrayList<String>) GenerateParenthesis.generateParenthesis(3);
        for(String s: tempList){
            System.out.println(s);
        }
    }
}
