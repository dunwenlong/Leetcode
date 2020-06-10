import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Dun
 */
public class Helloworld2 {
    public static void main(String[] args){
        System.out.println(cuttingRope(127));
    }
    public static long quickPowerMod(long x, int a, int p){
        long res = 1;
        while(a!=0){
            if((a&1)!=0){
                res = ((res%p)*x%p)%p;
            }
            x = ((x%p)*(x%p))%p;
            a = a>>1;
        }
        return res;
    }
    public static int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        int x = n%3;
        int y = n/3;
        long res = 0;
        int p = 1000000007;
        if(x == 0){
            res = quickPowerMod(3, y, p)%p;
        }
        if(x == 1){
            res = (quickPowerMod(3, y-1, p)%p*4)%p;
        }
        if(x == 2){
            res = (quickPowerMod(3, y, p)%p*2)%p;
        }
        return (int)res;

    }
    public static char firstUniqChar(String s) {
        char[] charArr = s.toCharArray();
        char result = ' ';
        Map<Character, Integer> charRecord= new HashMap<Character, Integer>();
        for(char c:charArr){
            charRecord.put(c, charRecord.getOrDefault(c, 0)+1);
        }
        for(char c:charArr){
            if(charRecord.get(c)==1){
                result = c;
            }
        }
        return result;
    }
    class MinStack {
        Stack<Integer> minStack;
        Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            Stack<Integer> helpStack = new Stack<>();
            if(minStack.isEmpty()){
                minStack.push(x);
            } else{
                while (x>minStack.peek()){
                    helpStack.push(minStack.pop());
                }
                minStack.push(x);
                while (!helpStack.isEmpty()){
                    minStack.push(helpStack.pop());
                }
            }
        }

        public void pop() {
            if(stack.isEmpty()){
                return;
            }
            if(minStack.peek().equals(stack.peek())){
                minStack.pop();
            }
            stack.pop();

        }
        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
